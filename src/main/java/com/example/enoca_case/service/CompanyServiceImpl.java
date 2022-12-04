package com.example.enoca_case.service;

import com.example.enoca_case.dto.CompanyDto;
import com.example.enoca_case.entity.Company;
import com.example.enoca_case.mapper.CompanyMapper;
import com.example.enoca_case.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    CompanyRepository companyRepository;
    CompanyMapper companyMapper;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public String save(CompanyDto companyDto) {
        companyRepository.save(companyMapper.convertEntity(companyDto));
        return "complete";
    }

    @Override
    public CompanyDto get(Integer id) {
        return companyMapper.map(companyRepository.getReferenceById(id));

    }

    @Override
    public List<CompanyDto> getAll() {
        return companyMapper.map3(companyRepository.findAll());

    }

    @Override
    public String delete(Integer no) {
        companyRepository.deleteById(no);
        return "silindi";
    }
}


