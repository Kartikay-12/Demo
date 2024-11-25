package com.example.demo.EO;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.exception.ResourceNotFoundException;


public interface IEmployeeEO {

	EmployeeDto createEmp(EmployeeDto save);

	EmployeeDto retrieveData(int id) throws ResourceNotFoundException;
	

}
