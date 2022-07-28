package model.parking;

import model.util.ParkingSpotType;

public class LargeVehicleParkingSpot extends ParkingSpot {

    public LargeVehicleParkingSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.LARGE);
    }

}
