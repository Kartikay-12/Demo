package com.example.demo.BO;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.EO.EmployeeEO;
import com.example.demo.exception.ResourceNotFoundException;

public interface IEmpBO {

	 
	public EmployeeDto createEmp(EmployeeDto empDto);
	 EmployeeDto retrieveData(int id) throws ResourceNotFoundException;
	public void healthCheck() throws Exception;
	 
	
}
