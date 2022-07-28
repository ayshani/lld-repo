package model.vehicle;

import model.util.VehicleType;

public class MotorBike extends Vehicle{
    public MotorBike(String licenseNumber) {
        super(licenseNumber, VehicleType.MOTORBIKE);
    }
}
