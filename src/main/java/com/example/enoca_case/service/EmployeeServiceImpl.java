package com.example.enoca_case.service;

import com.example.enoca_case.dto.EmployeeDto;
import com.example.enoca_case.mapper.EmployeeMapper;
import com.example.enoca_case.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class EmployeeServiceImpl implements  EmployeeService{

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public String save(EmployeeDto employeeDto) {
        employeeRepository.save(employeeMapper.convertEntity(employeeDto));
        return "kayıt başarılı";
    }

    @Override
    public EmployeeDto get(Long id) {
        return employeeMapper.map(employeeRepository.getReferenceById(id));
    }
    @Override
    public List<EmployeeDto> getAll() {
        return employeeMapper.mapList(employeeRepository.findAll());
    }

    @Override
    public String delete(Long id) {
        employeeRepository.deleteById(id);
        return "delete is complete";
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        employeeRepository.save(employeeMapper.convertEntity(employeeDto));
        return employeeMapper.map(employeeRepository.getReferenceById(employeeDto.getId()));
    }
}
