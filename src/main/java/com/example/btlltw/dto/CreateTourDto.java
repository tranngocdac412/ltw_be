package com.example.btlltw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTourDto implements Serializable {
    private int priceOfTicket;

    private int numberOfGuest;

    private int car_id;

    private int route_id;

    private int mainDriver_id;

    private int extraDriver_id;

}
