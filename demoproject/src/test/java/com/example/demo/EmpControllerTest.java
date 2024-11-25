package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.VO.EmployeeVO;
import com.example.demo.controller.EmpController;
import com.example.demo.service.IEmpService;

@ExtendWith(MockitoExtension.class)
public class EmpControllerTest {

	@Mock
	private IEmpService empService;

	@InjectMocks
	private EmpController empController;

	private MockMvc mockMvc;

	private EmployeeVO employeeVO;

	

}
