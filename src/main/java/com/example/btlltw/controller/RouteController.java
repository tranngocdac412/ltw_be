package com.example.btlltw.controller;


import com.example.btlltw.entity.Route;
import com.example.btlltw.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @GetMapping(params = "id")
    public ResponseEntity<?> getRouteById(@RequestParam(name = "id") int id){
        return new ResponseEntity<>(routeService.getRouteById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createRoute(@Valid @RequestBody Route body) {
        final Route createdRoute = routeService.createRoute(body);
        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
    }

    @PutMapping(params = "id")
    public ResponseEntity<?> updateRouteById(@RequestParam(name = "id") int id, @Valid @RequestBody Route body){
        final Route updatedRoute = routeService.updateRouteById(id, body);
        return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> deleteRouteById(@RequestParam(name = "id") int id){
        routeService.deleteRouteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllRoute(){
        return new ResponseEntity<>(routeService.getAllRoute(), HttpStatus.OK);
    }
}
