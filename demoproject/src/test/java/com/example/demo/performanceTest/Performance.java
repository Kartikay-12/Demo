package com.example.demo.performanceTest;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import io.gatling.javaapi.http.HttpRequestActionBuilder;

public class Performance extends Simulation {

	// HTTP Protocol Configuration
	HttpProtocolBuilder httpProtocol = http.baseUrl("http://localhost:8080").acceptHeader("application/json")
			.contentTypeHeader("application/json");

	String jsonPayload = "{" + "\"id\": 1," + "\"name\": \"Ayush\"," + "\"address\": \"1234 Street City\","
			+ "\"department\": \"IT\"" + "}";

	// Define the POST request for creating an employee
	HttpRequestActionBuilder createEmployeeRequest = http("Create Employee").post("/create") // The POST request to the
																								// /create endpoint
			.body(StringBody(jsonPayload)).asJson().check(status().is(201)); // Expecting HTTP 201 Created as response

	// Define the scenario: Send requests to create an employee
	ScenarioBuilder scn = scenario("Employee Create Load Test").exec(createEmployeeRequest); // No pause between
																								// requests

	// Set up the load test with user injection
	{
		setUp(scn.injectOpen(atOnceUsers(5), // Inject 5 users at once (concurrent requests)
				rampUsers(10).during(1) // Ramp up to 10 users over 5 seconds
		).protocols(httpProtocol));
	}
}
