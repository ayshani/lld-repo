package model.parking;

import model.util.ParkingSpotType;

public class ElectricBikeParkingSpot extends ParkingSpot {

    public ElectricBikeParkingSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.EBIKE);
    }

}