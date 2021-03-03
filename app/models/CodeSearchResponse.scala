package models

import play.api.libs.json.Json

object CodeSearchResponse {

  case class CodeSearchResponse(total_count: Int)

  object CodeSearchResponse {
    implicit val formats = Json.format[CodeSearchResponse]
  }

}
