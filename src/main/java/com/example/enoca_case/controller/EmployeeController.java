package com.example.enoca_case.controller;

import com.example.enoca_case.dto.CompanyDto;
import com.example.enoca_case.dto.EmployeeDto;
import com.example.enoca_case.service.EmployeeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@Component
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/save")
    public String save(@RequestBody EmployeeDto employeeDto)
    {
        return employeeService.save(employeeDto);
    }

    @GetMapping("/get")
    public EmployeeDto get(@RequestParam Long id)
    {
        return employeeService.get(id);
    }

    @GetMapping("/getAll")
    public List<EmployeeDto> getAll()
    {
        return employeeService.getAll();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id)
    {
        return employeeService.delete(id);

    }

    @PostMapping("/update")
    public EmployeeDto update(@RequestBody EmployeeDto employeeDto)
    {
        return employeeService.update(employeeDto);
    }

}
