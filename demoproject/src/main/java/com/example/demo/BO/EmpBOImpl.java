package com.example.demo.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.EO.IEmployeeEO;
import com.example.demo.dao.IEmpRepo;
import com.example.demo.exception.ResourceNotFoundException;

@Component
public class EmpBOImpl implements IEmpBO {

	@Autowired
	private IEmpRepo empRepo;
	@Autowired
	private IEmployeeEO empEO;
	
	public EmpBOImpl(IEmployeeEO empEO) {
		this.empEO=empEO;
	}

	@Override
	public EmployeeDto createEmp(EmployeeDto empDto) {
		 //logger.info("BO layer- creating new Employee");
		 return empEO.createEmp(empDto);
	}

	@Override
	public EmployeeDto retrieveData(int id) throws ResourceNotFoundException {
		return empEO.retrieveData(id);
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
