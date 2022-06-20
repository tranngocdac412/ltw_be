package com.example.btlltw.dto;

import javax.validation.constraints.NotEmpty;

public class CreateCarDto {
    @NotEmpty
    private String licensePlate;

    @NotEmpty
    private String color;

    @NotEmpty
    private String brand;

    @NotEmpty
    private String version;

    @NotEmpty
    private String model;

    @NotEmpty
    private String amountOfSeat;

//    private String lastMaintainDay;
}
