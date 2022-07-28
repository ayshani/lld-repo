package model.vehicle;

import model.util.VehicleType;

public class EV extends Vehicle{
    public EV(String licenseNumber) {
        super(licenseNumber, VehicleType.EV);
    }
}
