package com.example.demo.EO;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.EmployeeDto;

@Component
public class EmployeeEO implements IEmployeeEO {

	@Override
	public EmployeeDto createEmp(EmployeeDto save) {
	//logger.info();
		return save;
	}

	@Override
	public EmployeeDto retrieveData(EmployeeDto employeeDto) {
		
		return employeeDto;
	}
	
	
	
}
