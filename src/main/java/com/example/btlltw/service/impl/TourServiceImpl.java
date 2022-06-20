package com.example.btlltw.service.impl;

import com.example.btlltw.dto.CreateTourDto;
import com.example.btlltw.entity.Car;
import com.example.btlltw.entity.Driver;
import com.example.btlltw.entity.Route;
import com.example.btlltw.entity.Tour;
import com.example.btlltw.exception.NotFoundException;
import com.example.btlltw.mapper.TourMapper;
import com.example.btlltw.repository.TourRepository;
import com.example.btlltw.service.CarService;
import com.example.btlltw.service.DriverService;
import com.example.btlltw.service.RouteService;
import com.example.btlltw.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private DriverService driverService;

    public Tour createTour(CreateTourDto tour) {
        System.out.println(tour + "dddddddddddddd");
        Car car = carService.getCarById(tour.getCar_id());
        if(car == null) throw new NotFoundException();
        Route route = routeService.getRouteById(tour.getRoute_id());
        if(route == null) throw new NotFoundException();
        Driver mainDriver = driverService.getDriverById(tour.getMainDriver_id());
        if(mainDriver == null) throw new NotFoundException();
        mainDriver.setStatus(1);
        driverService.updateDriver(mainDriver);
        Driver extraDriver = driverService.getDriverById(tour.getExtraDriver_id());
        if(extraDriver == null ) throw new NotFoundException();
        extraDriver.setStatus(2);
        driverService.updateDriver(extraDriver);
        Tour t = new Tour();
        t.setPriceOfTicket(tour.getPriceOfTicket());
        t.setNumberOfGuest(tour.getNumberOfGuest());
        t.setCar(car);
        t.setRoute(route);
        t.setMainDriver(mainDriver);
        t.setExtraDriver(extraDriver);
        Tour createdTour = tourRepository.save(t);
        System.out.println(createdTour + "00000000000000000");
        return createdTour;
    }

    public Tour getTourById(int id){
        return tourRepository.getById(id);
    }

    public Tour updateTourById(int id, CreateTourDto tour) {
        Tour existTour = tourRepository.getById(id);
        System.out.println(existTour + "0000000000");
        if(existTour == null) throw new NotFoundException();
        existTour.setPriceOfTicket(tour.getPriceOfTicket());
        existTour.setNumberOfGuest(tour.getNumberOfGuest());
        System.out.println("aaaaaaaaaaaaaaaaaaaa");
        Car car = carService.getCarById(tour.getCar_id());
        if(car == null) throw new NotFoundException();
        System.out.println(car + "fffffffffffffffffffffff");
        Route route = routeService.getRouteById(tour.getRoute_id());
        if(route == null) throw new NotFoundException();
        System.out.println(route + "hhhhhhhhhhhhhhhhh");
        Driver mainDriver = driverService.getDriverById(tour.getMainDriver_id());
        if(mainDriver == null) throw new NotFoundException();
        System.out.println(mainDriver + "77777777777777777777");
        mainDriver.setStatus(1);
        driverService.updateDriver(mainDriver);
        Driver extraDriver = driverService.getDriverById(tour.getExtraDriver_id());
        if(extraDriver == null ) throw new NotFoundException();
        extraDriver.setStatus(2);
        driverService.updateDriver(extraDriver);
        existTour.setCar(car);
        existTour.setRoute(route);
        existTour.setMainDriver(mainDriver);
        existTour.setExtraDriver(extraDriver);
        System.out.println(existTour + "8888888888888888888888888888");
        Tour updateTour = tourRepository.save(existTour);
        return updateTour;
    }

    public Boolean deleteTourById(int id) {
        Tour exitTour = tourRepository.getById(id);
        if(exitTour == null) throw new NotFoundException();
        tourRepository.deleteById(id);
        return true;
    }

    public List<Tour> getAllTour() {
        return tourRepository.findAll();
    }

    public Boolean deleteAllByCar(Car car) {
        try{
            tourRepository.deleteAllByCar(car);
            System.out.println("+++=================");
            return true;
        } catch (NullPointerException e){
            throw e;
        }
    }

    public Boolean deleteAllByRoute(Route route) {
        try{
            tourRepository.deleteAllByRoute(route);
            System.out.println("+++=================");
            return true;
        } catch (NullPointerException e){
            throw e;
        }
    }

    public Boolean deleteAllByDriver(Driver driver) {
        try{
            tourRepository.deleteAllByExtraDriver(driver);
            tourRepository.deleteAllByMainDriver(driver);
            System.out.println("+++=================");
            return true;
        } catch (NullPointerException e){
            throw e;
        }
    }
}
