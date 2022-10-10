package com.rideshare.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Ride {
    private User rideGiver;
    private Vehicle rideVehicle;
    @Setter
    private int availableSeats;
    private String origin;
    private String destination;
    private Date startTime;
    private int rideDuration;
}
