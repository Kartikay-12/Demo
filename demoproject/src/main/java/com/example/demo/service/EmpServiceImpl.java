package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BO.IEmpBO;
import com.example.demo.EO.EmployeeEO;
import com.example.demo.MapStruct.EmpMapper;
import com.example.demo.VO.EmployeeVO;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class EmpServiceImpl implements IEmpService {

	@Autowired
	private IEmpBO empBo;
	private EmpMapper empMapper;

	public EmpServiceImpl(EmpMapper mapper) {
		this.empMapper = mapper; // Spring injects the mapper here
	}

	private static Logger logger = LoggerFactory.getLogger(EmpServiceImpl.class);

	@Override
	public EmployeeVO createData(EmployeeVO empVo) {
		logger.info("Service layer- creating new Employee");
		EmployeeEO empEo = empMapper.toEntity(empVo);
		EmployeeVO savedVo=empMapper.toVo(empBo.createEmp(empEo));
		return savedVo;

	}

	@Override
	public EmployeeVO retrieveData(int id) throws ResourceNotFoundException {
		logger.info("Service layer- retrieving employee detail by id");
		EmployeeEO empEo=empBo.retrieveData(id);
		return empMapper.toVo(empEo);
	}

	@Override
	public void healthCheck() throws Exception{
		logger.info("Service layer- checking health");
		 empBo.healthCheck();
		
		
	}

}
