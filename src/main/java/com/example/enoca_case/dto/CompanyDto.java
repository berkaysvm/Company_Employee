package com.example.enoca_case.dto;

import com.example.enoca_case.entity.Company;
import com.example.enoca_case.entity.Employee;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDto {
    private int id;
    private int company_no;
    private String company_name;
    private List<EmployeeDto> employees;


    public CompanyDto(Builder builder)
    {
        this.id=builder.id;
        this.company_no = builder.company_no;
        this.company_name=builder.company_name;
        this.employees=builder.employees;

    }
    public static class Builder
    {
        private int id;
        private int company_no;
        private String company_name;
        private List<EmployeeDto> employees;

        public Builder(){}

        public static Builder CompanyDtoBuilderWith()
        {
            return new Builder();
        }
        public Builder id(int id){this.id=id; return this;}
        public Builder company_no(int company_no){this.company_no = company_no; return this;}
        public Builder company_name(String company_name){this.company_name = company_name; return this;}
        public Builder employees(List<EmployeeDto> employeesDtos){this.employees=employeesDtos; return this;}


        public CompanyDto build()
        {
            return new CompanyDto(this);
        }
    }
}
