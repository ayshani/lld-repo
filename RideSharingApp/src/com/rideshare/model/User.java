package com.rideshare.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class User {
    private String id;
    private String name;
    private Gender gender;
    private int age;
    private Set<Vehicle> vehicles;
    private int ridesTaken;
    private int rideOffered;

    public User(String name, Gender gender, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicles = new HashSet<>();
        this.ridesTaken = 0;
        this.rideOffered = 0;
    }

    public boolean hasVehicle(Vehicle vehicle){
        return this.vehicles.contains(vehicle);
    }

    public int getNumberOfVehicles(){
        return this.vehicles.size();
    }

    public void addVehcile(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }
}
