package com.example.demo.utility;

import com.example.demo.DTO.EmployeeDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.xml.bind.JAXBException;

public class JaxBConversion {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String convertToJson(EmployeeDto employee) throws Exception {
		return objectMapper.writeValueAsString(employee);
	}

	public static EmployeeDto convertFromJson(String json, Class<EmployeeDto> object) throws Exception {
		return objectMapper.readValue(json, object);
	}

	public static void main(String[] args) throws Exception {
		try {
			// Create a sample User object
			EmployeeDto employee = new EmployeeDto();
			employee.setId(1);
			employee.setName("kartiky");
			employee.setAddress("123 ABC Street");
			employee.setDepartment("CSE");

			// Convert object to JSON
			String json = JaxBConversion.convertToJson(employee);
			System.out.println("POJO to JSON:");
			System.out.println(json);

			// Convert JSON back to Object
			EmployeeDto userFromJson = JaxBConversion.convertFromJson(json, EmployeeDto.class);
			System.out.println("\n JSON to POJO:");
			System.out.println(userFromJson);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
