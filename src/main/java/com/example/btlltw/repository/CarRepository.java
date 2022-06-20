package com.example.btlltw.repository;

import com.example.btlltw.dto.CreateCarDto;
import com.example.btlltw.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CarRepository  extends JpaRepository<Car, Integer> {
    @Query(value = "select * from car where car.id = :id ", nativeQuery = true)
    Car getCarById(@Param("id") int id);
}
