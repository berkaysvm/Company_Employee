package com.example.enoca_case.service;

import com.example.enoca_case.dto.CompanyDto;
import com.example.enoca_case.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    String save(EmployeeDto employeeDto);
    EmployeeDto get(Long id);
    List<EmployeeDto> getAll();

    String delete(Long id);
    EmployeeDto update(EmployeeDto employeeDto);
}
