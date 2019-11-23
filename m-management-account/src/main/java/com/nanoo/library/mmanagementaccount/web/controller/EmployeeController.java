package com.nanoo.library.mmanagementaccount.web.controller;

import com.nanoo.library.mmanagementaccount.model.dto.EmployeeDto;
import com.nanoo.library.mmanagementaccount.service.contractService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 01:00
 */
@RestController
public class EmployeeController {
    
    private final EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/employes")
    public List<EmployeeDto> test(){
        
        return employeeService.getEmployeeList();
        
    }
}
