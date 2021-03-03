package controllers

import models.CodeSearchResponse.CodeSearchResponse
import org.joda.time.DateTime
import play.api.Configuration
import play.api.libs.ws._
import play.api.mvc._
import play.twirl.api.Html
import utils.Services.allServices

import javax.inject.{Inject, _}
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

@Singleton
class HomeController @Inject()(val ws: WSClient, val controllerComponents: ControllerComponents, config: Configuration) extends BaseController {

  val ghPersonalAccessToken: String = config.get[String]("gh_token")

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>

    val searchValue: String = config.get[String]("keyword")

    def request(repo: String, searchValue: String): Future[WSResponse] = {
      val request = ws.url(s"https://api.github.com/search/code?q=$searchValue+repo%3Ahmrc%2F$repo&type=Code")
        .withRequestTimeout(10000.millis)
        .addHttpHeaders("Accept" -> "application/vnd.github.v3+json")
        .withHttpHeaders(headers = "Authorization" -> s"token $ghPersonalAccessToken")
        request.get()
    }

    Ok(views.html.index(Html(allServices.collect(repo => {
      Await.result(request(repo, searchValue), Duration.Inf) match {
        case response if response.status == 200 => {
          val foundCount = response.json.as[CodeSearchResponse].total_count
          if(foundCount > 0)
            s"Found $foundCount occurrences of '$searchValue' in repo $repo"
          else
            s"Found 0 occurrences of '$searchValue' in repo $repo"
        }
        case _ => s"Failed for $repo repo"
      }
    }
    ).reduce((found, otherFound) => found + "<br>" + otherFound))))
  }

  def rateLimitRequest: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>

    val result = Await.result(ws.url(s"https://api.github.com/rate_limit")
      .withRequestTimeout(10000.millis)
      .addHttpHeaders("Accept" -> "application/vnd.github.v3+json")
      .withHttpHeaders(headers = "Authorization" -> s"token $ghPersonalAccessToken")
      .get(), Duration.Inf)

    val epochString = (result.json \ "resources" \ "search" \ "reset").get.toString()
    val requestsAllowed = (result.json \ "resources" \ "search" \ "limit").get.toString()
    val remaining = (result.json \ "resources" \ "search" \ "remaining").get.toString()
    val rateLimitEndsAt: DateTime = new DateTime(epochString.toLong * 1000)

    val html: Html = if (remaining == 0) {
      Html(s"Search rate limit resets for another $requestsAllowed requests at $rateLimitEndsAt")
    } else if (remaining.toInt < 30){
      Html(s"You have $remaining requests until the limit resets to $requestsAllowed requests at $rateLimitEndsAt")
    } else {
      Html(s"You have the full allowance of $requestsAllowed requests")
    }

    Ok(views.html.index(html))
  }
}
