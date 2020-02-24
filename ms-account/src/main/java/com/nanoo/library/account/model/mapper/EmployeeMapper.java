package com.nanoo.library.account.model.mapper;

import com.nanoo.library.account.model.dto.EmployeeDto;
import com.nanoo.library.account.model.entities.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:30
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    
    Employee fromDtoToEmployee (EmployeeDto employeeDto);
    
    @InheritInverseConfiguration
    EmployeeDto fromEmployeeToDto (Employee employee);

}
