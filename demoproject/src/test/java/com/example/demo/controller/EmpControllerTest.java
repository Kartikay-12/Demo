package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.VO.EmployeeVO;
import com.example.demo.service.IEmpService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmpController.class)
public class EmpControllerTest {

	@MockBean
	private IEmpService empService;

	@Autowired
	private MockMvc mockMvc;
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setup() {
		objectMapper = new ObjectMapper();
	}

	@Test
	public void testCreateData() throws Exception {

		EmployeeVO empVo = new EmployeeVO();
		empVo.setId(1);
		empVo.setName("abcd");
		empVo.setAddress("123 abcd jhkdj");
		empVo.setDepartment("IT");

		when(empService.createData(empVo)).thenReturn(empVo);
		String jsonRequest = objectMapper.writeValueAsString(empVo);

		mockMvc.perform(post("/api/create").contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
				.andExpect(status().isCreated()).andExpect(content().json(jsonRequest));
	}

	@Test
	public void testRetrieveData() throws Exception {

		EmployeeVO empVo = new EmployeeVO();
		empVo.setId(1);
		empVo.setName("Abcd");
		empVo.setAddress("123 Efghijkln");
		empVo.setDepartment("Ijklms");

		when(empService.retrieveData(1)).thenReturn(empVo);

		mockMvc.perform(get("/api/retrieve/{id}", 1)).andExpect(status().isOk());
	}
}
