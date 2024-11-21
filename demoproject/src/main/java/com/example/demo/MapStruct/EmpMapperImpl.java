package com.example.demo.MapStruct;

import javax.annotation.processing.Generated;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.VO.EmployeeVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-18T14:11:18+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class EmpMapperImpl implements EmpMapper {

    @Override
    public EmployeeDto toDto(EmployeeVO empVo) {
        if ( empVo == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( empVo.getId() );
        employeeDto.setName( empVo.getName() );
        employeeDto.setAddress( empVo.getAddress() );
        employeeDto.setDepartment( empVo.getDepartment() );

        return employeeDto;
    }

    @Override
    public EmployeeVO toVo(EmployeeDto empDto) {
        if ( empDto == null ) {
            return null;
        }

        EmployeeVO employeeVO = new EmployeeVO();

        employeeVO.setId( empDto.getId() );
        employeeVO.setName( empDto.getName() );
        employeeVO.setAddress( empDto.getAddress() );
        employeeVO.setDepartment( empDto.getDepartment() );

        return employeeVO;
    }
}
