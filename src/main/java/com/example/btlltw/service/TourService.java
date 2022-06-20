package com.example.btlltw.service;

import com.example.btlltw.dto.CreateTourDto;
import com.example.btlltw.entity.Car;
import com.example.btlltw.entity.Driver;
import com.example.btlltw.entity.Route;
import com.example.btlltw.entity.Tour;

import java.util.List;

public interface TourService {
    Tour createTour(CreateTourDto tour);

    Tour getTourById(int id);

    Tour updateTourById(int id, CreateTourDto tour);

    Boolean deleteTourById(int id);

    List<Tour> getAllTour();

    Boolean deleteAllByCar(Car car);

    Boolean deleteAllByRoute(Route route);

    Boolean deleteAllByDriver(Driver driver);
}
