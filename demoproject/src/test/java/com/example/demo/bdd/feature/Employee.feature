Feature: Employee Management System

  Scenario: Create a new employee
    Given employee details
    When I create the employee
    Then the employee should be created

  Scenario: Retrieve an existing employee
    Given an employee with id 1 exists
    When I retrieve the employee with id 1
    Then I should get the employee details
