package com.example.demo.MapStruct;

import com.example.demo.EO.EmployeeEO;
import com.example.demo.VO.EmployeeVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-18T14:11:18+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class EmpMapperImpl implements EmpMapper {

    @Override
    public EmployeeEO toEntity(EmployeeVO empVo) {
        if ( empVo == null ) {
            return null;
        }

        EmployeeEO employeeEO = new EmployeeEO();

        employeeEO.setId( empVo.getId() );
        employeeEO.setName( empVo.getName() );
        employeeEO.setAddress( empVo.getAddress() );
        employeeEO.setDepartment( empVo.getDepartment() );

        return employeeEO;
    }

    @Override
    public EmployeeVO toVo(EmployeeEO empEO) {
        if ( empEO == null ) {
            return null;
        }

        EmployeeVO employeeVO = new EmployeeVO();

        employeeVO.setId( empEO.getId() );
        employeeVO.setName( empEO.getName() );
        employeeVO.setAddress( empEO.getAddress() );
        employeeVO.setDepartment( empEO.getDepartment() );

        return employeeVO;
    }
}
