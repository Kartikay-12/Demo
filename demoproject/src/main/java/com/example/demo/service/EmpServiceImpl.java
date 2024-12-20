package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BO.IEmpBO;
import com.example.demo.DTO.EmployeeDto;
import com.example.demo.MapStruct.EmpMapper;
import com.example.demo.VO.EmployeeVO;
import com.example.demo.exception.ResourceNotFoundException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmpServiceImpl implements IEmpService {

	@Autowired
	private IEmpBO empBo;
	@Autowired
	private EmpMapper empMapper;

	private static Logger logger = LoggerFactory.getLogger(EmpServiceImpl.class);
	private static final String service = "empService";

	@CircuitBreaker(name = service, fallbackMethod = "createFallback")
	@Override
	public EmployeeVO createData(EmployeeVO empVo) {
		logger.info("Service layer- creating new Employee");
		if (empVo.getDepartment().isEmpty()) {
			logger.error("Failure occured: one of the feild is empty");
			throw new IllegalArgumentException("Department name is empty");
		}
		try {
			EmployeeDto empDto = empMapper.toDto(empVo);
			EmployeeVO savedVo = empMapper.toVo(empBo.createEmp(empDto));
			return savedVo;
		} catch (Exception e) {
			logger.error("Error occurred while creating employee: {}", e.getMessage());
		}
		return empVo;
	}

	
	@Override
	public EmployeeVO retrieveData(int id) throws ResourceNotFoundException {
		logger.info("Service layer- retrieving employee detail by id");
		EmployeeDto empDto = empBo.retrieveData(id);
		return empMapper.toVo(empDto);
	}

	@Override
	public void healthCheck() throws Exception {
		logger.info("Service layer- checking health");
		empBo.healthCheck();
	}

	public String createFallback(Throwable e) {
		logger.error("Fallback triggered due to: {}", e.getMessage());
		return "Fallback: Unable to create Employee";
	}

}
