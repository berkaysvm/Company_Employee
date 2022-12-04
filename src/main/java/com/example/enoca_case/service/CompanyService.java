package com.example.enoca_case.service;

import com.example.enoca_case.dto.CompanyDto;
import com.example.enoca_case.entity.Company;

import java.util.List;


public interface CompanyService {

    String save(CompanyDto companyDto);
    CompanyDto get(Integer id);
    String delete(Integer id);
    List<CompanyDto> getAll();
}
