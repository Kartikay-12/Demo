package com.example.demo.utility;

import java.io.StringWriter;

import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.example.demo.DTO.EmployeeDto;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;


	public class PojoJsonConversion
	{
		public static void main(String[] args)
		{
			EmployeeDto employee = new EmployeeDto();
			employee.setId(1);
			employee.setName("Kartikay");
			employee.setAddress("Abc Street city");
			employee.setDepartment("IT");
			jaxbObjectToJSON(employee);
		}
		private static void jaxbObjectToJSON(EmployeeDto employee)
		{
		    try
		    {
		        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeDto.class);
		        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		        // To format JSON
		        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		        //Set JSON type
		        jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		        jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		        //Print JSON String to Console
		        StringWriter sw = new StringWriter();
		        jaxbMarshaller.marshal(employee, sw);
		        System.out.println(sw.toString());
		    }
		    catch (JAXBException e)
		    {
		        e.printStackTrace();
		    }
		}
	}
