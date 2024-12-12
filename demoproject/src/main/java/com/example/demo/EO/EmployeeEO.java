package com.example.demo.EO;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.dao.IEmpRepo;
import com.example.demo.exception.ResourceNotFoundException;

@Component
public class EmployeeEO implements IEmployeeEO {

	@Autowired
	private IEmpRepo empRepo;

	private static Logger logger = LoggerFactory.getLogger(EmployeeEO.class);

	@Override
	public EmployeeDto createEmp(EmployeeDto empDto) {
		logger.info("Saving Data into the database");
		return empRepo.save(empDto);
	}

	@Override
	public EmployeeDto retrieveData(int id) throws ResourceNotFoundException {
		Optional<EmployeeDto> empDto = empRepo.findById(id);
		if (empDto.isPresent()) {
			logger.info("Retrieving Employee with Id :", id);
			return empDto.get();
		} else
			throw new ResourceNotFoundException("Record not found");
	}

}
