package org.carrental.service;

import org.carrental.exception.NoAvilableVehicles;
import org.carrental.model.Location;
import org.carrental.model.User;
import org.carrental.model.Vehicle;
import org.carrental.model.VehicleReservation;
import org.carrental.util.ReservationStatus;
import org.carrental.util.VehicleStatus;

import java.util.*;

public class Store {



    private VehicleInventoryService vehicleInventoryService;
    private UserService userService;
    Map<String, VehicleReservation>  reservationMap;
    private String storeId;
    private Location location;

    /*
    VehicleInventoryService has one-to-one relationship with store
    i.e. every store will have it's own VehicleInventory. Hence we are initializing new object on
    Store object creation.
    But wrt UserService, it is only one across the whole application.
    Hence we are injecting this on every store.
     */
    public Store(Location location, UserService userService){
        this.storeId = UUID.randomUUID().toString();
        this.vehicleInventoryService = new VehicleInventoryService();
        this.userService = userService;
    }

    public VehicleReservation reserveVehicle(User user, Vehicle vehicle , Date startDate, Date endDate, String pickUpLocation, String returnLocation){

            VehicleReservation vehicleReservation = new VehicleReservation(vehicle,user,startDate,endDate,new Date(),pickUpLocation,returnLocation);
            vehicle.setVehicleStatus(VehicleStatus.RESERVED);
            this.reservationMap.put(vehicleReservation.getReservationId(), vehicleReservation);
            this.vehicleInventoryService.addReversationToVehicle(vehicle, vehicleReservation);
            this.userService.addUserReservation(user, vehicleReservation);
            return vehicleReservation;

    }
    public VehicleReservation reserveVehicle(User user , Date startDate, Date endDate, String pickUpLocation, String returnLocation){
        List<Vehicle>  availableVehicles = getAllAvailableVehicles();
        VehicleReservation vehicleReservation = null;
        if(null != availableVehicles) {
            Vehicle reservedVehicle = availableVehicles.get(0);
            vehicleReservation = reserveVehicle(user,reservedVehicle,startDate,endDate,pickUpLocation,returnLocation);
            return vehicleReservation;
        } else{
            throw new NoAvilableVehicles("No Available vehicles in Store.....");
        }
    }

    public void cancelReservation(VehicleReservation vehicleReservation){
        vehicleReservation.updateReservationStatus(ReservationStatus.CANCELLED); // cancel reservation
        vehicleReservation.getVehicle().setVehicleStatus(VehicleStatus.AVAILABLE); // make vehicle available
    }

    public void startTrip(String reservationId){
        VehicleReservation vehicleReservation =  reservationMap.getOrDefault(reservationId,null);
        if(null != vehicleReservation){
            updateReservationAndVehicleStatus(vehicleReservation, ReservationStatus.INPROGRESS, VehicleStatus.BEING_SERVICED);

        }
    }

    public void endTrip(String reservationId){
        VehicleReservation vehicleReservation =  reservationMap.getOrDefault(reservationId,null);
        if(null != vehicleReservation){
            updateReservationAndVehicleStatus(vehicleReservation, ReservationStatus.COMPLETED, VehicleStatus.AVAILABLE);
        }
    }
    public List<VehicleReservation> getReservation(User user ){
        return this.userService.findReservationsByUser(user);
    }

    public void addVehicleToStore(Vehicle vehicle){
        this.vehicleInventoryService.addVehicle(vehicle);
    }

    public List<Vehicle> getAllAvailableVehicles(){
       return this.vehicleInventoryService.getAvailableVehicles();
    }



    private void updateReservationAndVehicleStatus(VehicleReservation vehicleReservation, ReservationStatus reservationStatus, VehicleStatus vehicleStatus) {
        vehicleReservation.updateReservationStatus(reservationStatus);
        vehicleReservation.getVehicle().setVehicleStatus(vehicleStatus);
    }

}
