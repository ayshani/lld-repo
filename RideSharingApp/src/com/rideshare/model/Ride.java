package com.rideshare.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ride {
    private User rideGiver;
    private Vehicle giverVehicle;
    private int availableSeats;
    private String origin;
    private String destination;
    private Date startTime;
    private int rideDuration;

    public Ride(User u, Vehicle v, int seats, String origin, String destination, Date startTime, int duration){
        this.rideGiver = u;
        this.giverVehicle = v;
        this.availableSeats = seats;
        this.origin = origin;
        this.destination = destination;
        this.startTime = startTime;
        this.rideDuration = duration;
    }


}
