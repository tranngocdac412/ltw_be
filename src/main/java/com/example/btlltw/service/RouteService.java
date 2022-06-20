package com.example.btlltw.service;

import com.example.btlltw.entity.Route;

import java.util.List;

public interface RouteService {
    Route getRouteById(int id);

    Route createRoute(Route body);

    Route updateRouteById(int id, Route body);

    Boolean deleteRouteById(int id);

    List<Route> getAllRoute();
}
