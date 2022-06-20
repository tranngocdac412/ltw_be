package com.example.btlltw.controller;


import com.example.btlltw.dto.CreateCarDto;
import com.example.btlltw.dto.CreateTourDto;
import com.example.btlltw.entity.Car;
import com.example.btlltw.entity.Tour;
import com.example.btlltw.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/tours")
public class TourController {
    @Autowired
    private TourService tourService;

    @GetMapping(params = "id")
    public ResponseEntity<Tour> getTourById(@RequestParam(name = "id") int id){
        return new ResponseEntity<>(tourService.getTourById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTour(@Valid @RequestBody CreateTourDto body) {
        final Tour createdTour = tourService.createTour(body);
        System.out.println(createdTour + "999999999999999999999999");
        return new ResponseEntity<>(createdTour, HttpStatus.CREATED);
    }

    @PutMapping(params = "id")
    public ResponseEntity<?> updateTourById(@RequestParam(name = "id") int id, @Valid @RequestBody CreateTourDto body){
        final Tour updatedTour = tourService.updateTourById(id, body);
        return new ResponseEntity<>(updatedTour, HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> deleteTourById(@RequestParam(name = "id") int id){
        tourService.deleteTourById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllTour(){
        return new ResponseEntity<>(tourService.getAllTour(), HttpStatus.OK);
    }
}
