package com.example.btlltw.service;

import com.example.btlltw.entity.Driver;
import java.util.List;

public interface DriverService {
    Driver getDriverById(int id);

    Driver createDriver(Driver body);

    Driver updateDriverById(int id, Driver body);

    Boolean deleteDriverById(int id);

    List<Driver> getAllDriver();

    Driver updateDriver(Driver driver);

    List<Driver> getExtraDriver();

    List<Driver> getMainDriver();
}
