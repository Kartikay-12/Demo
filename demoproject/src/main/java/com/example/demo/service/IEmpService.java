package com.example.demo.service;

import com.example.demo.VO.EmployeeVO;
import com.example.demo.exception.ResourceNotFoundException;

public interface IEmpService {

	EmployeeVO retrieveData(int id) throws ResourceNotFoundException;

	EmployeeVO createData(EmployeeVO empVo);

	String healthCheck() throws Exception;

}
