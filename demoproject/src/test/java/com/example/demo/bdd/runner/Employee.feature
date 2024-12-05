Feature: Employee Management System

  Scenario: Create a new employee
    Given employee details with Id: <Id> Name: <Name> Address: <Address> Department: <Department>
    When I create the employee 
    Then the employee should be created
    
    Examples:
    		|	Id	|	Name	   |		Address			|	Department	|
    		|	1	|   "Kartikay" |	"123 Street city"	|	"CS" 		|


  Scenario: Retrieve an existing employee
    Given an employee with id: <Id> exists
    When I retrieve the employee with id: <Id>
    Then I should get the employee details
    
    Examples:
    		|	Id	|	Name		|		Address			|	Department	|
    		|	1	|	"Kartikay"	|	"123 Street city"	|	"CS" 		|
