package com.example.demo.MapStruct;

import org.mapstruct.Mapper;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.VO.EmployeeVO;

@Mapper(componentModel="spring")
public interface EmpMapper {
	EmployeeDto toDto(EmployeeVO empVo);
	EmployeeVO toVo(EmployeeDto empEO);
}

