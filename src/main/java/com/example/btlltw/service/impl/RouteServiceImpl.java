package com.example.btlltw.service.impl;

import com.example.btlltw.entity.Driver;
import com.example.btlltw.entity.Route;
import com.example.btlltw.exception.NotFoundException;
import com.example.btlltw.repository.RouteRepository;
import com.example.btlltw.service.RouteService;
import com.example.btlltw.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private TourService tourService;

    public Route createRoute(Route route) {
        System.out.println(route);
        Route createdRoute = routeRepository.save(route);
        System.out.println(createdRoute);
        return createdRoute;
    }

    public Route getRouteById(int id){
        System.out.println(id);
        Route r =  routeRepository.getById(id);
        System.out.println(r);
        return r;
    }

    public Route updateRouteById(int id, Route route) {
        Route exitRoute = routeRepository.getById(id);
        if(exitRoute == null) throw new NotFoundException();
        Route updateRoute = routeRepository.save(route);
        return updateRoute;
    }

    public Boolean deleteRouteById(int id) {
        Route exitRoute = routeRepository.getById(id);
        if(exitRoute == null) throw new NotFoundException();
        tourService.deleteAllByRoute(exitRoute);
        routeRepository.deleteById(id);
        return true;
    }

    public List<Route> getAllRoute() {
        return routeRepository.findAll();
    }
}
