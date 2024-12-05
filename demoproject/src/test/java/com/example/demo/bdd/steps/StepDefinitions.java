package com.example.demo.bdd.steps;

import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.VO.EmployeeVO;
import com.example.demo.exception.ResourceNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest
public class StepDefinitions {

//	@Autowired
//	private IEmpService empService;
	private String BASE_URL = "http://localhost:8080/api";
	private String create = "/create";
	private String retrieve = "/retrieve/";

	private RestTemplate restTemplate;
	EmployeeVO empVO = new EmployeeVO();
	private EmployeeVO response;

	public StepDefinitions() {
		// Initialize RestTemplate
		this.restTemplate = new RestTemplate();
	}

	@Given("employee details with Id: {int} Name: {string} Address: {string} Department: {string}")
	public void givenIHaveANewEmployee(int id, String name, String address, String department) {

		empVO.setId(id);
		empVO.setName(name);
		empVO.setAddress(address);
		empVO.setDepartment(department);
	}

	@When("I create the employee")
	public void whenICreateTheEmployee() {
		ResponseEntity<EmployeeVO> responseEntity = restTemplate.postForEntity(BASE_URL + create, empVO,
				EmployeeVO.class);
		response = responseEntity.getBody();
//		response = empService.createData(empVO);
	}

	@Then("the employee should be created")
	public void thenTheEmployeeShouldBeCreatedWithId() {

		Assertions.assertEquals(empVO.getName(), response.getName());
	}

	@Given("an employee with id: {int} exists")
	public void givenAnEmployeeWithIdExists(int id) {

		empVO.setId(id);
		empVO.setName("Kartikay");
		empVO.setAddress("123 Street, City");
		empVO.setDepartment("CS");

	}

	@When("I retrieve the employee with id: {int}")
	public void whenIRetrieveTheEmployeeWithId(int id) throws ResourceNotFoundException {
		response = restTemplate.getForObject(BASE_URL + "/" + retrieve + id, EmployeeVO.class);
	}

	@Then("I should get the employee details")
	public void thenIShouldGetTheEmployeeDetails() {

		Assertions.assertEquals(empVO.getName(), response.getName());
	}
}
