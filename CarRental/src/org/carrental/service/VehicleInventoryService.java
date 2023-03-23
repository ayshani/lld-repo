package org.carrental.service;

import org.carrental.model.Vehicle;
import org.carrental.model.VehicleReservation;
import org.carrental.util.VehicleStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VehicleInventoryService {
    private Map<String,Vehicle> vehicles;
    private Map<Vehicle, List<VehicleReservation>> vehicleReservationMap;

    public VehicleInventoryService(){
        vehicles =  new HashMap<>();
        vehicleReservationMap = new HashMap<>();
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

    public void addReversationToVehicle(Vehicle vehicle, VehicleReservation vehicleReservations){
        this.vehicleReservationMap.putIfAbsent(vehicle,  new ArrayList<>());
        this.vehicleReservationMap.get(vehicle).add(vehicleReservations);
    }

    public List<VehicleReservation> findReservationsByVehicle(Vehicle vehicle){
        if(vehicleReservationMap.get(vehicle) !=null)
            return this.vehicleReservationMap.get(vehicle);
        return List.of();
    }

    public List<Vehicle> getAvailableVehicles(){
        List<Vehicle> availableVehicles = this.vehicles.values().stream()
                .filter(vehicle -> vehicle.getVehicleStatus().equals(VehicleStatus.AVAILABLE))
                .collect(Collectors.toList());
        return availableVehicles;
    }
}
