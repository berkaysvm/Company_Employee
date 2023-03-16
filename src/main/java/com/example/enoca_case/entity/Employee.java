package com.example.enoca_case.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;
    private String lastname;
    private int age;
    @ManyToOne(cascade =CascadeType.MERGE,fetch = FetchType.EAGER,targetEntity = com.example.enoca_case.entity.Company.class)
    @JoinColumn(name = "company_id")
    private Company company;
}
