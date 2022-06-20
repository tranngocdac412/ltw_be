package com.example.btlltw.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDriver implements Serializable{
    private int id;

    private String address;

    private String cmt;

    private String license;

    private String name;

    private int seniority;

    private String type_of_license;

    private int number_of_guest;

    private int price_of_ticket;

    private int main_driver_id;

    private int extra_driver_id;

    private int complexity;
}
