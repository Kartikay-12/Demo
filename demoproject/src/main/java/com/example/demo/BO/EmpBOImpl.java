package com.example.demo.BO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.EO.EmployeeEO;
import com.example.demo.MapStruct.EmpMapper;
import com.example.demo.VO.EmployeeVO;
import com.example.demo.dao.IEmpRepo;
import com.example.demo.exception.ResourceNotFoundException;

@Component
public class EmpBOImpl implements IEmpBO {

	@Autowired
	private IEmpRepo empRepo;
	private EmpMapper empMapper;

	public EmpBOImpl(EmpMapper mapper) {
		this.empMapper = mapper; // Spring injects the mapper here
	}

	public EmployeeVO createEmp(EmployeeVO empVo) {
		// logger.info("BO layer- creating new Employee");
		EmployeeEO empEo = empMapper.toEntity(empVo);
		EmployeeEO savedEmp = empRepo.save(empEo);
		return empMapper.toVo(savedEmp);
	}

	public EmployeeVO retrieveData(int id) throws ResourceNotFoundException {
		Optional<EmployeeEO> empEo = empRepo.findById(id);
		if (empEo.isPresent()) {
			// logger.info("Retrieving Employee with Id :", id);
			return empMapper.toVo(empEo.get());
		} else
			throw new ResourceNotFoundException("Record not found");
	}
}
