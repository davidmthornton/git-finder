package utils

object Services {

  private val atedRepositories = List(
    "ated-frontend", "ated", "ated-acceptance-tests", "ated-stub", "ated-subscription-frontend",
    "ated-subscription", "agent-client-mandate-acceptance-tests", "agent-client-mandate-stub",
    "agent-client-mandate-frontend", "agent-client-mandate", "ated-performance-tests", "ated-subscription-stub",
    "delegation", "agent-client-mandate-performance-tests", "ated-contract-tests"
  )

  private val awrsRepositories: List[String] = List("awrs-frontend", "awrs", "awrs-acceptance-tests", "awrs-stubs",
    "awrs-lookup-frontend",	"awrs-lookup","awrs-lookup-acceptance-tests",	"awrs-lookup-stub",
    "awrs-notification", "awrs-lookup-performance-tests"
  )

  private val businessCustomerRepositories: List[String] = List("business-customer-frontend",	"business-customer",
    "business-customer-acceptance-tests",	"business-customer-stub", "business-matching",
    "business-partner-contract-tests"
  )

  private val cestRepositories: List[String] = List("off-payroll-acceptance-tests", "off-payroll-frontend",
    "off-payroll-decision", "off-payroll-performance-test"
  )

  val sdltcRepositories: List[String] = List("sdltc-frontend", "sdltc-acceptance-tests", "sdltc-performance-tests")

  private val sspRepositories: List[String] = List(
    "coronavirus-statutory-sick-pay-frontend", "coronavirus-statutory-sick-pay-claim",
    "coronavirus-statutory-sick-pay-perf-tests", "coronavirus-statutory-sick-pay-stub",
    "coronavirus-statutory-sick-pay-mgmt-frontend",	"coronavirus-statutory-sick-pay-scheme",
    "coronavirus-statutory-sick-pay-journey-tests", "coronavirus-ssp-helpdesk-frontend",
    "coronavirus-statutory-sick-pay-file-processor", "coronavirus-helpdesk-frontend")

  private val safetyAndSecurityRepositories: List[String] = List(
    "iced-subscription-frontend",	"import-control-entry-declaration-decision",	"iced-decision-acceptance-tests",
    "import-control-entry-declaration-eis-stub", "import-control-entry-declaration-admin-frontend",
    "import-control-entry-declaration-events", "iced-decision-performance-tests",	"import-control-entry-declaration-stub",
    "import-control-entry-declaration-test-frontend",	"import-control-entry-declaration-intervention",
    "iced-events-acceptance-tests", "safety-and-security-import-service-guide",	"import-control-entry-declaration-outcome",
    "iced-events-performance-tests", "import-control-entry-declaration-store", "iced-intervention-acceptance-tests",
    "iced-intervention-performance-tests", "iced-outcome-performance-tests", "iced-subscription-acceptance-tests",
    "iced-subscription-performance-tests", "import-control-entry-declaration-api-acceptance-tests",
    "import-control-entry-declaration-api-contract-tests", "import-control-entry-declaration-api-performance-tests"
  )

  val allServices: List[String] = List("app-config-production")

//    atedRepositories ++ awrsRepositories ++ businessCustomerRepositories ++
//    cestRepositories ++ sdltcRepositories ++ sspRepositories ++ safetyAndSecurityRepositories

}
