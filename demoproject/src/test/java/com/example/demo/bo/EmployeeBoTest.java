package com.example.demo.bo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.BO.EmpBOImpl;
import com.example.demo.DTO.EmployeeDto;
import com.example.demo.EO.IEmployeeEO;
import com.example.demo.dao.IEmpRepo;
import com.example.demo.exception.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
public class EmployeeBoTest {

	
	@InjectMocks
	private EmpBOImpl empBO;

	@Mock
	private IEmpRepo empRepo;

	@Mock
	private IEmployeeEO empEO;

	@Test
	public void retrieveDataTest() throws ResourceNotFoundException {

		EmployeeDto e1 = new EmployeeDto();
		e1.setId(1);
		e1.setName("Abcd");
		e1.setAddress("Efghijklmn");
		e1.setDepartment("Ijklms");

		when(empEO.retrieveData(1)).thenReturn(e1);

		EmployeeDto e2 = empBO.retrieveData(1);

		Assertions.assertEquals(e1, e2);
	}

	@Test
	public void testCreateEmp() {

		EmployeeDto e1 = new EmployeeDto();
		e1.setId(1);
		e1.setName("Abcd");
		e1.setAddress("Efghijklmn");
		e1.setDepartment("Ijklms");
		when(empEO.createEmp(e1)).thenReturn(e1);

		EmployeeDto e2 = empBO.createEmp(e1);

		Assertions.assertEquals(e1, e2);

	}
}
