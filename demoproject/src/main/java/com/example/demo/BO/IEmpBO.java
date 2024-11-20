package com.example.demo.BO;

import com.example.demo.EO.EmployeeEO;
import com.example.demo.exception.ResourceNotFoundException;

public interface IEmpBO {

	 
	public EmployeeEO createEmp(EmployeeEO empEo);
	 EmployeeEO retrieveData(int id) throws ResourceNotFoundException;
	public void healthCheck() throws Exception;
	 
	
}
