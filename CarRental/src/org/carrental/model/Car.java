package org.carrental.model;

import org.carrental.util.VehicleType;

import java.util.UUID;

public class Car extends Vehicle{
    public Car(int licenseNumber, int dailyRentalCost, int hourlyRentalCost, int passengerCapacity) {
        super(licenseNumber, VehicleType.CAR, dailyRentalCost,
                hourlyRentalCost, passengerCapacity);
    }

    @Override
    public String toString() {
        return "Car{" +
                "vehicleID='" + vehicleID + '\'' +
                ", licenseNumber=" + licenseNumber +
                ", vehicleType=" + vehicleType +
                ", dailyRentalCost=" + dailyRentalCost +
                ", hourlyRentalCost=" + hourlyRentalCost +
                ", passengerCapacity=" + passengerCapacity +
                ", vehicleStatus=" + vehicleStatus +
                "} " + super.toString();
    }
}
