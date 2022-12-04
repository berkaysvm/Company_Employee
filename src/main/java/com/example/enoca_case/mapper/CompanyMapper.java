package com.example.enoca_case.mapper;

import com.example.enoca_case.dto.CompanyDto;
import com.example.enoca_case.dto.EmployeeDto;
import com.example.enoca_case.entity.Company;
import com.example.enoca_case.entity.Employee;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapper {

    public CompanyDto map(Company company)
    {
        EmployeeMapper emloyeeMapper= new EmployeeMapper();
        List<Employee> employeeList = company.getEmployees();
        List<EmployeeDto> employeeDtoList = employeeList.stream().map(emloyeeMapper::map2).collect(Collectors.toList());

        return CompanyDto.Builder.CompanyDtoBuilderWith()
                .id(company.getId())
                .company_no(company.getCompany_no())
                .company_name(company.getCompany_name())
                .employees(employeeDtoList)
                .build();
    }
    public CompanyDto map2(Company company)
    {
        EmployeeMapper emloyeeMapper= new EmployeeMapper();
        List<Employee> employeeList = company.getEmployees();
        List<EmployeeDto> employeeDtoList = employeeList.stream().map(emloyeeMapper::map2).collect(Collectors.toList());


        return CompanyDto.Builder.CompanyDtoBuilderWith()
                .id(company.getId())
                .company_name(company.getCompany_name())
                .company_no(company.getCompany_no())
                .employees(employeeDtoList)
                .build();
    }
    public CompanyDto mapGetEmpl(Company company)
    {

        return CompanyDto.Builder.CompanyDtoBuilderWith()
                .id(company.getId())
                .company_name(company.getCompany_name())
                .company_no(company.getCompany_no())
                .build();
    }

    public List<CompanyDto> map3(List<Company> company)
    {
        List<Company> companies = company;
        List<CompanyDto> companyDtos = companies.stream().map(this::map2).collect(Collectors.toList());
        return companyDtos;

    }

    public Company convertEntity(CompanyDto companyDto)
    {
        Company company = new Company();
        company.setCompany_name(companyDto.getCompany_name());
        company.setCompany_no(companyDto.getCompany_no());
        return company;
    }
    public Company convertEntity2(CompanyDto companyDto)
    {
        Company company = new Company();
        company.setId(companyDto.getId());
        return company;
    }
}