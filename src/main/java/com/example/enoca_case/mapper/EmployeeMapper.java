package com.example.enoca_case.mapper;

import com.example.enoca_case.dto.EmployeeDto;
import com.example.enoca_case.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    CompanyMapper companyMapper = new CompanyMapper();

    public EmployeeDto map(Employee employee)
    {
        return EmployeeDto.Builder.EmployeeDtoBuilderWith()
                .id(employee.getId())
                .name(employee.getName())
                .lastname(employee.getLastname())
                .age(employee.getAge())
                .companDto(companyMapper.mapGetEmpl(employee.getCompany()))
                .build();
    }
    public EmployeeDto map2(Employee employee)
    {
        return EmployeeDto.Builder.EmployeeDtoBuilderWith()
                .id(employee.getId())
                .name(employee.getName())
                .lastname(employee.getLastname())
                .age(employee.getAge())
                .companDto(companyMapper.mapGetEmpl(employee.getCompany()))
                .build();
    }
    public List<EmployeeDto> mapList(List<Employee> employeeList)
    {
        List<Employee> employees= employeeList;
        List<EmployeeDto> employeeDtoList = employees.stream().map(this::map2).collect(Collectors.toList());
        return employeeDtoList;
    }




    public Employee convertEntity(EmployeeDto employeeDto)
    {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setLastname(employeeDto.getLastname());
        employee.setAge(employeeDto.getAge());
        employee.setCompany(companyMapper.convertEntity2(employeeDto.getCompanyDto()));
        return employee;

    }
}
