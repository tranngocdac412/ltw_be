package com.example.btlltw.service;

import com.example.btlltw.dto.SalaryStatisticDto;
import com.example.btlltw.entity.Driver;
import com.example.btlltw.entity.Salary;

import java.util.List;

public interface SalaryService {
    Salary getSalaryById(int id);

    Salary createSalary(Salary body);

    List<SalaryStatisticDto> getSalaryStatistic();

    Boolean deleteSalaryById(int id);

    List<Salary> getAllSalary();

    Salary updateSalaryById(int id, Salary salary);
}
