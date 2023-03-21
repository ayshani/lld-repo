package org.carrental.service;

import org.carrental.model.Vehicle;
import org.carrental.util.VehicleStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VehicleInventoryService {
    private Map<String,Vehicle> vehicles;

    public VehicleInventoryService(){
        vehicles =  new HashMap<>();
    }
    public void addVehicles(List<Vehicle> vehicles){
        vehicles.forEach(vehicle -> this.vehicles.put(vehicle.getVehicleID(),vehicle));
    }

    public List getAllVehicles(){
        return new ArrayList<>(this.vehicles.values());
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicles.put(vehicle.getVehicleID(),vehicle);
    }

    public boolean isAvailableForReservation(Vehicle vehicle){
        if(this.vehicles.get(vehicle.getVehicleID()) != null){
            return VehicleStatus.AVAILABLE.equals(this.vehicles.get(vehicle.getVehicleID()).getVehicleStatus());
        }
        return false;
    }

    public void changeVehicleStatus(Vehicle vehicle, VehicleStatus vehicleStatus){
        if(this.vehicles.get(vehicle.getVehicleID()) != null){
            this.vehicles.get(vehicle.getVehicleID()).setVehicleStatus(vehicleStatus);
        }
    }

}
