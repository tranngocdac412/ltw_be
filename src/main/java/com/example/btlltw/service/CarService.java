package com.example.btlltw.service;

import com.example.btlltw.dto.CreateCarDto;
import com.example.btlltw.entity.Car;
import javassist.NotFoundException;

import java.util.List;

public interface CarService {
    Car getCarById(int id);

    Car createCar(Car body);

    Car updateCarById(int id, Car body);

    Boolean deleteCarById(int id);

    List<Car> getAllCar();
}
