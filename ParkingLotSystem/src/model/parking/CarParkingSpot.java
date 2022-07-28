package model.parking;

import model.util.ParkingSpotType;

public class CarParkingSpot extends ParkingSpot {

    public CarParkingSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.CAR);
    }

}
