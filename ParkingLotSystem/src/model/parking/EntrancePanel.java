package model.parking;

import model.util.TicketStatus;
import model.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public class EntrancePanel {
    private String id;

    public EntrancePanel(String id) {
        this.id = id;
    }

    public ParkingTicket getParkignTicket(Vehicle vehicle){
        ParkingLot parkingLot = ParkingLot.getInstance();
        if(!parkingLot.canPark(vehicle.getType()))
            return null;
            // throw exception
        ParkingSpot  parkingSpot = parkingLot.getParkingSpot(vehicle.getType());
        if(null == parkingSpot)
            return null;

        return buildTicket(vehicle.getLicenseNumber(),parkingSpot.getParkingSpotId());
    }

    private ParkingTicket buildTicket(String licenseNumber, String parkingSpotId) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.setIssuedAt(LocalDateTime.now());
        parkingTicket.setTicketNumber(UUID.randomUUID().toString());
        parkingTicket.setTicketStatus(TicketStatus.ACTIVE);
        parkingTicket.setLicensePlateNumber(licenseNumber);
        parkingTicket.setAllocatedSpotId(parkingSpotId);
        return parkingTicket;
    }
}
