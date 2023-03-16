package com.example.enoca_case.controller;

import com.example.enoca_case.dto.CompanyDto;
import com.example.enoca_case.entity.Company;
import com.example.enoca_case.globalexception.Notfound;
import com.example.enoca_case.service.CompanyService;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/save")
    public String save(@RequestBody CompanyDto companyDto)
    {
        return companyService.save(companyDto);
    }

    @GetMapping("/get")

    public CompanyDto get(@RequestParam Integer id) throws EntityNotFoundException
    {
        try {
            return companyService.get(id);

        }
        catch (EntityNotFoundException exception)
        {
            throw new Notfound("Aradığınız Şirket Bulunamamıştır");

        }

    }





    @GetMapping("/getAll")
    public List<CompanyDto> getAll()
    {
        return companyService.getAll();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Integer id)
    {
        return companyService.delete(id);
    }




}
