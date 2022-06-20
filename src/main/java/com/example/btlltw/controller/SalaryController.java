package com.example.btlltw.controller;


import com.example.btlltw.entity.Driver;
import com.example.btlltw.entity.Salary;
import com.example.btlltw.service.RouteService;
import com.example.btlltw.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/salaries")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping(params = "id")
    public ResponseEntity<?> getSalaryById(@RequestParam(name = "id") int id){
        return new ResponseEntity<>(salaryService.getSalaryById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSalary(@Valid @RequestBody Salary body) {
        final Salary createdSalary = salaryService.createSalary(body);
        return new ResponseEntity<>(createdSalary, HttpStatus.CREATED);
    }

    @PutMapping(params = "id")
    public ResponseEntity<?> updateSalaryById(@RequestParam(name = "id") int id, @Valid @RequestBody Salary body){
        final Salary updatedSalary = salaryService.updateSalaryById(id, body);
        return new ResponseEntity<>(updatedSalary, HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> deleteSalaryById(@RequestParam(name = "id") int id){
        salaryService.deleteSalaryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public List<Salary> getAllSalary(){
        return salaryService.getAllSalary();
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> getSalaryStatistic(){
        System.out.println("---------------0000000000000");
        return new ResponseEntity<>(salaryService.getSalaryStatistic(),HttpStatus.OK);
    }
}
