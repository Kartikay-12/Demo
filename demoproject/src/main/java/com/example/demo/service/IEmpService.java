package com.example.demo.service;

import com.example.demo.VO.EmployeeVO;

public interface IEmpService {

	EmployeeVO retrieveData(int id) throws Exception;

	EmployeeVO createData(EmployeeVO empVo);

}
