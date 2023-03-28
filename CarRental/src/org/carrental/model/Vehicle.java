package org.carrental.model;

import lombok.Getter;
import lombok.Setter;
import org.carrental.util.VehicleStatus;
import org.carrental.util.VehicleType;

import java.util.UUID;

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

    public Vehicle(int licenseNumber, VehicleType vehicleType, int dailyRentalCost, int hourlyRentalCost, int passengerCapacity) {
        this.vehicleID = UUID.randomUUID().toString();
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.dailyRentalCost = dailyRentalCost;
        this.hourlyRentalCost = hourlyRentalCost;
        this.passengerCapacity = passengerCapacity;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID='" + vehicleID + '\'' +
                ", licenseNumber=" + licenseNumber +
                ", vehicleType=" + vehicleType +
                ", dailyRentalCost=" + dailyRentalCost +
                ", hourlyRentalCost=" + hourlyRentalCost +
                ", passengerCapacity=" + passengerCapacity +
                ", vehicleStatus=" + vehicleStatus +
                '}';
    }
}
