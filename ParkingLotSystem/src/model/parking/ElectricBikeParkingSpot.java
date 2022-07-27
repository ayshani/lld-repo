package model.parking;

public class ElectricBikeParkingSpot extends ParkingSpot {

    public ElectricBikeParkingSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.EBIKE);
    }

}