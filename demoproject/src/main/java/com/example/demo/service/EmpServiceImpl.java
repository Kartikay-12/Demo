package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BO.EmpBOImpl;
import com.example.demo.VO.EmployeeVO;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class EmpServiceImpl implements IEmpService {

	@Autowired
	private EmpBOImpl empBo;

	private static Logger logger = LoggerFactory.getLogger(EmpServiceImpl.class);

	@Override
	public EmployeeVO createData(EmployeeVO empVo) {
		logger.info("Service layer- creating new Employee");
		return empBo.createEmp(empVo);

	}

	@Override
	public EmployeeVO retrieveData(int id) throws ResourceNotFoundException {
		logger.info("Service layer- retrieving employee detail by id");
		return empBo.retrieveData(id);
	}

}
