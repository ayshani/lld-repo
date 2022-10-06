package com.rideshare.service;

import com.rideshare.model.Ride;

import java.util.Comparator;

public class EarliestRide implements Comparator<Ride> {
    @Override
    public int compare(Ride ride1, Ride ride2) {
        return ride1.getStartTime().compareTo(ride2.getStartTime());
    }
}
