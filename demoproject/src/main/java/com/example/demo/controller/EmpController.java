package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.VO.EmployeeVO;
import com.example.demo.service.EmpServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpController {
	
	@Autowired
	private EmpServiceImpl empService;
	
	private static Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeVO> createData(@RequestBody EmployeeVO empVo){
		logger.info("Received request to create Employee");
		return ResponseEntity.ok(empService.createData(empVo));
		
		
	}
	
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<EmployeeVO> retrieveData(@PathVariable("id") int id ) throws Exception{
		logger.info("Received reques to fetach Employee by Id");
		return ResponseEntity.ok(empService.retrieveData(id));
		
	}
	
	
	
}