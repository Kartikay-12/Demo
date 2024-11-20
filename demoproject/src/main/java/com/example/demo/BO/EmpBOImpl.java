package com.example.demo.BO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.EO.EmployeeEO;
import com.example.demo.dao.IEmpRepo;
import com.example.demo.exception.ResourceNotFoundException;

@Component
public class EmpBOImpl implements IEmpBO {

	@Autowired
	private IEmpRepo empRepo;
	

	@Override
	public EmployeeEO createEmp(EmployeeEO empEo) {
		 //logger.info("BO layer- creating new Employee");
		return empRepo.save(empEo);
	}

	@Override
	public EmployeeEO retrieveData(int id) throws ResourceNotFoundException {
		Optional<EmployeeEO> empEo = empRepo.findById(id);
		if (empEo.isPresent()) {
			// logger.info("Retrieving Employee with Id :", id);
			return empEo.get();
		} else
			throw new ResourceNotFoundException("Record not found");
	}

	@Override
	public void healthCheck() throws Exception{
		try {
			empRepo.getById(0.0);
		}
		catch (ArithmeticException e) {
	       
	        throw new ArithmeticException("HealthCheck good" );
	    } catch (Exception e) {
	        
	        throw new Exception("HealthCheck good");
	    }
			
		}
		
		
	}
