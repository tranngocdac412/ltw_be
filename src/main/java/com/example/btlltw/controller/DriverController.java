package com.example.btlltw.controller;

import com.example.btlltw.dto.GetAllDriver;
import com.example.btlltw.entity.Driver;
import com.example.btlltw.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping(params = "id")
    public ResponseEntity<?> getDriverById(@RequestParam(name = "id") int id){
        return new ResponseEntity<>(driverService.getDriverById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCar(@Valid @RequestBody Driver body) {
        final Driver createdDriver = driverService.createDriver(body);
        return new ResponseEntity<>(createdDriver, HttpStatus.CREATED);
    }

    @PutMapping(params = "id")
    public ResponseEntity<?> updateCarById(@RequestParam(name = "id") int id, @Valid @RequestBody Driver body){
        final Driver updatedDriver = driverService.updateDriverById(id, body);
        return new ResponseEntity<>(updatedDriver, HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> deleteDriverById(@RequestParam(name = "id") int id){
        driverService.deleteDriverById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public  List<Driver> getAllDriver(){
        return driverService.getAllDriver();
    }
}
