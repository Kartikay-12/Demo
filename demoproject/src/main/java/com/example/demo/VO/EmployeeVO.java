package com.example.demo.VO;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeVO {
	
	private int id;
	private String name;
	@Size(min = 10, max = 50, message = "Name must have a max of 10 chracter and not less than 5 characters")
	private String address;
	private String department;
}
