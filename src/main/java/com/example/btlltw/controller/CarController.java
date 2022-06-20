package com.example.btlltw.controller;

import com.example.btlltw.dto.CreateCarDto;
import com.example.btlltw.entity.Car;
import com.example.btlltw.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping(params = "id")
    public ResponseEntity<Car> getCarById(@RequestParam(name = "id") int id){
       return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllCar(){
        return new ResponseEntity<>(carService.getAllCar(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCar(@Valid @RequestBody Car body) {
        final Car createdCar = carService.createCar(body);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping(params = "id")
    public ResponseEntity<?> updateCarById(@RequestParam(name = "id") int id, @Valid @RequestBody Car body){
        final Car updatedCar = carService.updateCarById(id, body);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> deleteCarById(@RequestParam(name = "id") int id){
        System.out.println(id);
        carService.deleteCarById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
