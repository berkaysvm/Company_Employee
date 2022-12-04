package com.example.enoca_case.dto;

import com.example.enoca_case.entity.Company;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private String lastname;
    private int age;
    private CompanyDto companyDto;

    public EmployeeDto(Builder builder)
    {
        this.id = builder.id;
        this.name= builder.name;
        this.lastname = builder.lastname;
        this.age = builder.age;
        this.companyDto = builder.companyDto;
    }
    public static class Builder
    {
        private Long id;
        private String name;
        private String lastname;
        private int age;
        private CompanyDto companyDto;

        public Builder(){}

        public static Builder EmployeeDtoBuilderWith()
        {
            return new Builder();
        }

        public Builder id(Long id){this.id = id; return this;}
        public Builder name(String name){this.name= name; return this; }
        public Builder lastname(String lastname){this.lastname=lastname; return this;}
        public Builder age(int age){this.age = age; return this;}
        public Builder companDto(CompanyDto companyDto){this.companyDto = companyDto; return this;}

        public EmployeeDto build()
        {
            return new EmployeeDto(this);
        }


    }

}
