package com.example.demo.EO;

import com.example.demo.DTO.EmployeeDto;


public interface IEmployeeEO {

	EmployeeDto createEmp(EmployeeDto save);

	EmployeeDto retrieveData(EmployeeDto employeeDto);
	

}
