package org.carrental.model;

import lombok.Getter;
import lombok.Setter;
import org.carrental.util.VehicleStatus;
import org.carrental.util.VehicleType;

@Getter
@Setter
public class Vehicle {
    String vehicleID;
    int licenseNumber;
    VehicleType vehicleType;
    int dailyRentalCost;
    int hourlyRentalCost;
    int passengerCapacity;
    VehicleStatus vehicleStatus;

    public Vehicle(String vehicleID, int licenseNumber, VehicleType vehicleType, int dailyRentalCost, int hourlyRentalCost, int passengerCapacity) {
        this.vehicleID = vehicleID;
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.dailyRentalCost = dailyRentalCost;
        this.hourlyRentalCost = hourlyRentalCost;
        this.passengerCapacity = passengerCapacity;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }
}
