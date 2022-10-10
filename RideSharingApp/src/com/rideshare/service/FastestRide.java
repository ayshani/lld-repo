package com.rideshare.service;

import com.rideshare.model.Ride;

import java.util.Comparator;

public class FastestRide implements Comparator<Ride> {
    @Override
    public int compare(Ride o1, Ride o2) {
        return o1.getRideDuration() - o2.getRideDuration();
    }
}
