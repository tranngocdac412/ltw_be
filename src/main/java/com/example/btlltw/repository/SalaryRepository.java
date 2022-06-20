package com.example.btlltw.repository;

import com.example.btlltw.dto.RouteAndMainDriverDto;
import com.example.btlltw.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    @Query(value = "select d.name from driver d inner join ( select t.main_driver_id, r.complexity, t.date from tour t inner join route r on t.route_id = r.id group by t.id) a on a.main_driver_id = d.id group by d.id;", nativeQuery = true)
    List<String> getListNameMainDriver();

    @Query(value = "select sum(a.complexity) from driver d inner join ( select t.main_driver_id, r.complexity, t.date from tour t inner join route r on t.route_id = r.id group by t.id) a on a.main_driver_id = d.id group by d.id;", nativeQuery = true)
    List<Integer> getListSumComplexityMainDriver();

    @Query(value = "select d.name from driver d inner join ( select t.extra_driver_id, r.complexity, t.date from tour t inner join route r on t.route_id = r.id group by t.id) a on a.extra_driver_id = d.id group by d.id;", nativeQuery = true)
    List<String> getNameExtraDriver();

    @Query(value = "select sum(a.complexity) from driver d inner join ( select t.extra_driver_id, r.complexity, t.date from tour t inner join route r on t.route_id = r.id group by t.id) a on a.extra_driver_id = d.id group by d.id;", nativeQuery = true)
    List<Integer> getListSumComplexityExtraDriver();
}
