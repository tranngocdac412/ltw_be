package com.example.btlltw.dto;

import com.example.btlltw.entity.Driver;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteAndMainDriverDto implements Serializable {
    @JsonProperty("id")
    private int id;

//    @JsonProperty("idDriver")
//    private int idDriver;
//
//    @JsonProperty("name")
//    private String name;

    @JsonProperty("driver")
    private Driver driver;

    @JsonProperty("complexity")
    private int complexity;
}
