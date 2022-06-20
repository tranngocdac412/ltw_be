package com.example.btlltw.repository;

import com.example.btlltw.dto.GetAllDriver;
import com.example.btlltw.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query(value = "select * from driver d\n" +
            "inner join ( select number_of_guest, price_of_ticket, main_driver_id from tour t \n" +
            "\t\t\t inner join route r \n" +
            "             on r.id = t.route_id) a on a.main_driver_id = d.id;", nativeQuery = true)
    List<Driver> getAllDriver();

    @Query(value = "select * from driver d inner join ( select t.extra_driver_id, r.complexity, t.date from tour t inner join route r on t.route_id = r.id group by t.id) a on a.extra_driver_id = d.id group by d.id;", nativeQuery = true)
    List<Driver> getExtraDriver();

    @Query(value = "select * from driver d inner join ( select t.main_driver_id, r.complexity, t.date from tour t inner join route r on t.route_id = r.id group by t.id) a on a.main_driver_id = d.id group by d.id;", nativeQuery = true)
    List<Driver> getMainDriver();
}
