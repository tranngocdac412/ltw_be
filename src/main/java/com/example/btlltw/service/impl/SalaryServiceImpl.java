package com.example.btlltw.service.impl;

import com.example.btlltw.dto.RouteAndMainDriverDto;
import com.example.btlltw.dto.SalaryStatisticDto;
import com.example.btlltw.entity.Driver;
import com.example.btlltw.entity.Route;
import com.example.btlltw.entity.Salary;
import com.example.btlltw.exception.NotFoundException;
import com.example.btlltw.repository.SalaryRepository;
import com.example.btlltw.service.DriverService;
import com.example.btlltw.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private DriverService driverService;

    public Salary getSalaryById(int id) {
        return salaryRepository.getById(id);
    }

    public Salary createSalary(Salary body) {
        Salary createdSalary = salaryRepository.save(body);
        return createdSalary;
    }

    public List<SalaryStatisticDto> getSalaryStatistic() {
        List<Driver> listMainDriver = driverService.getMainDriver();
        List<Integer> listSumComplexityMainDriver = salaryRepository.getListSumComplexityMainDriver();
        List<RouteAndMainDriverDto> listMain = new ArrayList<>();
        int i = 0;
        for (Driver element : listMainDriver) {
            RouteAndMainDriverDto routeAndMainDriverDto = new RouteAndMainDriverDto();
            routeAndMainDriverDto.setDriver(element);
            routeAndMainDriverDto.setComplexity(listSumComplexityMainDriver.get(i++));
            listMain.add(routeAndMainDriverDto);
        }
        Salary mainDriverSalary = salaryRepository.getById(1);
        for (RouteAndMainDriverDto element : listMain) {
            element.setComplexity((int) element.getComplexity() * mainDriverSalary.getIndexMoney());
        }
        List<Driver> listExtraDriver = driverService.getExtraDriver();
        List<Integer> listSumComplexityExtraDriver = salaryRepository.getListSumComplexityExtraDriver();
        List<RouteAndMainDriverDto> listExtra = new ArrayList<>();
        int j = 0;
        for (Driver element : listExtraDriver) {
            RouteAndMainDriverDto routeAndExtraDriverDto = new RouteAndMainDriverDto();
            routeAndExtraDriverDto.setDriver(element);
            routeAndExtraDriverDto.setComplexity(listSumComplexityExtraDriver.get(j++));
            listExtra.add(routeAndExtraDriverDto);
        }
        Salary extraDriverSalary = salaryRepository.getById(2);
        for (RouteAndMainDriverDto element : listExtra) {
            element.setComplexity((int) element.getComplexity() * extraDriverSalary.getIndexMoney());
        }
        List<SalaryStatisticDto> salaryStatisticDtoList = new ArrayList<>();
        for (RouteAndMainDriverDto element : listMain) {
            for (RouteAndMainDriverDto item : listExtra) {
                if (element.getDriver().getId() == item.getDriver().getId()) {
                    SalaryStatisticDto salaryStatisticDto = new SalaryStatisticDto();
                    salaryStatisticDto.setSalary(element.getComplexity() + item.getComplexity());
                    salaryStatisticDto.setDriver(element.getDriver());
                    salaryStatisticDtoList.add(salaryStatisticDto);
                    break;
                }
            }
        }

        System.out.println(salaryStatisticDtoList + "3333333333");
            System.out.println(listMain + "main");
            List<SalaryStatisticDto> newSalaryStatistic = new ArrayList<>();
            for (RouteAndMainDriverDto element : listMain) {
                int k=0;
                for (SalaryStatisticDto item : salaryStatisticDtoList) {
                    if (element.getDriver().getId() == item.getDriver().getId()) {
                        k =1;
                        System.out.println(element.getDriver().getId() + "  " + item.getDriver().getId());
                    }
                }
                if(k == 0) {
                    SalaryStatisticDto salaryStatisticDto = new SalaryStatisticDto();
                    salaryStatisticDto.setSalary(element.getComplexity());
                    salaryStatisticDto.setDriver(element.getDriver());
                    newSalaryStatistic.add(salaryStatisticDto);
                }
            }
        System.out.println(listExtra + "extra");
            for (RouteAndMainDriverDto element : listExtra) {
                int k=0;
                for (SalaryStatisticDto item : salaryStatisticDtoList) {
                    if (element.getDriver().getId() == item.getDriver().getId()) {
                        k = 1;

                    }
                }
                if(k ==0 ){
                    SalaryStatisticDto salaryStatisticDto = new SalaryStatisticDto();
                    salaryStatisticDto.setSalary(element.getComplexity());
                    salaryStatisticDto.setDriver(element.getDriver());
                    newSalaryStatistic.add(salaryStatisticDto);
                }
            }
            System.out.println(salaryStatisticDtoList);
            salaryStatisticDtoList.addAll(newSalaryStatistic);
        System.out.println(newSalaryStatistic);
            return salaryStatisticDtoList;
        }

        public Salary updateSalaryById ( int id, Salary salary){
            Salary exitSalary = salaryRepository.getById(id);
            if (exitSalary == null) throw new NotFoundException();
            exitSalary.setName(salary.getName());
            exitSalary.setIndexMoney(salary.getIndexMoney());
            Salary updateSalary = salaryRepository.save(exitSalary);
            return updateSalary;
        }

        public Boolean deleteSalaryById ( int id){
            Salary exitSalary = salaryRepository.getById(id);
            if (exitSalary == null) throw new NotFoundException();
            salaryRepository.deleteById(id);
            return true;
        }

        public List<Salary> getAllSalary () {
            return salaryRepository.findAll();
        }
}
