package com.nanoo.library.mmanagementaccount.service.implService;

import com.nanoo.library.mmanagementaccount.database.EmployeeRepository;
import com.nanoo.library.mmanagementaccount.model.dto.EmployeeDto;
import com.nanoo.library.mmanagementaccount.model.entities.Employee;
import com.nanoo.library.mmanagementaccount.model.mapper.EmployeeMapper;
import com.nanoo.library.mmanagementaccount.service.contractService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:56
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }
    
    @Override
    public List<EmployeeDto> getEmployeeList() {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
    
        List<Employee> employees = employeeRepository.findAll();
    
        for (Employee employee : employees){
            employeeDtos.add(employeeMapper.fromEmployeeToDto(employee));
        }
    
        return employeeDtos;
    }
}
