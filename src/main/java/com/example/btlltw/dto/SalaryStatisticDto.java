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
public class SalaryStatisticDto implements Serializable {
    @JsonProperty("id")
    private int id;

    @JsonProperty("driver")
    private Driver driver;

    @JsonProperty("salary")
    private int salary;
}
