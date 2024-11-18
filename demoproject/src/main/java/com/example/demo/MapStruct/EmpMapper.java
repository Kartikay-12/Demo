package com.example.demo.MapStruct;

import org.mapstruct.Mapper;

import com.example.demo.EO.EmployeeEO;
import com.example.demo.VO.EmployeeVO;

@Mapper(componentModel="spring")
public interface EmpMapper {
	EmployeeEO toEntity(EmployeeVO empVo);
	EmployeeVO toVo(EmployeeEO empEO);
}

