package com.example.enoca_case.repository;

import com.example.enoca_case.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
