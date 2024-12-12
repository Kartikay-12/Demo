package com.example.demo.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Entity
@Data
@XmlRootElement
public class EmployeeDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement
	private int id;
	@NotNull
	@XmlElement
	private String name;
	@Size(min = 10, max = 50, message = "Name must have a max of 10 chracter and not less than 5 characters")
	@XmlElement
	private String address;
	@XmlElement
	private String department;
	
}
