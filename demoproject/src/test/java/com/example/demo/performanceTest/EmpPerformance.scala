import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class EmpPerformance extends Simulation{

	val httpProtocol = http.baseUrl("http://localhost:8080/api")
			.acceptHeader("application/json")
			
	val createEmployeeScn = scenario("Create Employee").exec(http("Create Employee")
        .post("/create").body(StringBody("""
          {
            "name: "Kartikay",
            "address": "123 ABC Street",
            "department": "IT"
          }
        """)).asJson
        .check(status.is(201))
    )
    setUp(
    createEmployeeScn.inject(atOnceUsers(5)).protocols(httpProtocol)
}