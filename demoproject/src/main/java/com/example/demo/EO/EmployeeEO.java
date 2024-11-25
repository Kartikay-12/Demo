package com.example.demo.EO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.dao.IEmpRepo;
import com.example.demo.exception.ResourceNotFoundException;

@Component
public class EmployeeEO implements IEmployeeEO {

	
	@Autowired
	private IEmpRepo empRepo;
	
	@Override
	public EmployeeDto createEmp(EmployeeDto empDto) {
	//logger.info();
		return empRepo.save(empDto);
	}

	@Override
	public EmployeeDto retrieveData(int id) throws ResourceNotFoundException {
		Optional<EmployeeDto> empDto = empRepo.findById(id);
		if (empDto.isPresent()) {
			// logger.info("Retrieving Employee with Id :", id);
			return empDto.get();
		} else
			throw new ResourceNotFoundException("Record not found");
	}
	
	
	
}
