package com.example.demo.bdd.steps;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.VO.EmployeeVO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.IEmpService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest
public class StepDefinitions {

	@Autowired
	private IEmpService empService;
	
	EmployeeVO empVO=new EmployeeVO();
	private EmployeeVO response;

	@Given("employee details with Id {int} Name {string} Address {string} Department {string}")
	public void givenIHaveANewEmployee(int id, String name, String address, String department) {
		
		empVO.setId(id);
		empVO.setName(name);
		empVO.setAddress(address);
		empVO.setDepartment(department);
	}

	@When("I create the employee")
	public void whenICreateTheEmployee() {
		response = empService.createData(empVO);
	}

	@Then("the employee should be created")
	public void thenTheEmployeeShouldBeCreatedWithId() {

		Assertions.assertEquals(empVO, response);
	}

	@Given("an employee with id {int} exists")
	public void givenAnEmployeeWithIdExists(int id) {
		
	}

	@When("I retrieve the employee with id {int}")
	public void whenIRetrieveTheEmployeeWithId(int id) throws ResourceNotFoundException {
		response = empService.retrieveData(id);
	}

	@Then("I should get the employee details")
	public void thenIShouldGetTheEmployeeDetails() {

		Assertions.assertEquals("Kartikay", response.getName());
	}
}
