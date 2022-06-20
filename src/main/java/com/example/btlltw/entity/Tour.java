package com.example.btlltw.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "tour")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Tour implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "priceOfTicket")
    private int priceOfTicket;

    @Column(name = "numberOfGuest")
    private int numberOfGuest;

    @Column(name = "date")
    private Date date;

    @ManyToOne()
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne()
    @JoinColumn(name="route_id")
    private Route route;

    @ManyToOne()
    @JoinColumn(name="mainDriver_id")
    private Driver mainDriver;

    @ManyToOne()
    @JoinColumn(name="extraDriver_id")
    private Driver extraDriver;
}
