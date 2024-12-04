Feature: Employee Management System

  Scenario: Create a new employee
    Given employee details with Id 1 Name "Kartikay" Address "123 Street City" Department "CS"
    When I create the employee 
    Then the employee should be created
    
    Examples:
    		|	Id	|	Name	|		Address			|	Department	|
    		|	1	|	Kartikay|	"123 Street city"	|	"CS" 		|


  Scenario: Retrieve an existing employee
    Given an employee with id 1 exists
    When I retrieve the employee with id 1
    Then I should get the employee details
    
    Examples:
    		|	Id	|	Name		|		Address			|	Department	|
    		|	1	|	"Kartikay"	|	"123 Street city"	|	"CS" 		|
