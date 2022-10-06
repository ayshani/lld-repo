package com.rideshare.repo;

import com.rideshare.model.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VehicleRepository {

    private List<Vehicle> allVehicles;

    public VehicleRepository(){
        allVehicles = new ArrayList<>();
    }
}
