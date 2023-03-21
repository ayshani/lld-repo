package org.carrental.service;

import org.carrental.model.User;
import org.carrental.model.Vehicle;
import org.carrental.model.VehicleReservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationService {
    private Map<User, List<VehicleReservation>> userReservationMap;
    private Map<Vehicle, List<VehicleReservation>> vehicleReservationMap;
    private VehicleInventoryService vehicleInventoryService;

    public ReservationService(VehicleInventoryService vehicleInventoryService){
        this.vehicleInventoryService = vehicleInventoryService;
        this.userReservationMap =  new HashMap<>();
        this.vehicleReservationMap =  new HashMap<>();
    }

    public void addReservation(User user, Vehicle vehicle ){

    }
    public void cancelReservation(User user ){

    }
    public List<VehicleReservation> getReservation(User user ){
        return userReservationMap.get(user);
    }
}
