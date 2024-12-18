package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DTO.EmployeeDto;

public interface IEmpRepo extends JpaRepository<EmployeeDto, Integer> {

	void getById(double d);

}
