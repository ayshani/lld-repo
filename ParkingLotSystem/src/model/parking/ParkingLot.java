package model.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingLot {

    private String parkingLotId;
    private Address address;

    private List<ParkingFloor> parkingFloors;
    private List<EntrancePanel> entrancePanels;
    private List<ExitPanel> exitPanels;

    // private constructor to restrict singleton
    private ParkingLot() {
        this.parkingLotId = UUID.randomUUID().toString();
        this.parkingFloors = new ArrayList<>();
        this.entrancePanels = new ArrayList<>();
        this.exitPanels = new ArrayList<>();
    }


    // singleton ParkingLot to ensure only one object of ParkingLot in the system,
    private static ParkingLot parkingLot = null;

    public static ParkingLot getInstance() {
        if(parkingLot==null)
            return new ParkingLot();
        return parkingLot;
    }

    public boolean isFull() {
        /*
         * check in all parking floors, if any floor is not empty,
         * that means Parking lot is not empty
         */
        for(ParkingFloor parkingfloor : parkingFloors) {
            if(!parkingfloor.isFloorFull())
                return false;
        }
        return true;
    }
}
