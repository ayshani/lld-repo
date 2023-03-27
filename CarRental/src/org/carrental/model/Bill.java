package org.carrental.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Bill {
    private Date paymentTimeStamp;
    private VehicleReservation vehicleReservation;

    public Bill(VehicleReservation vehicleReservation){
        this.vehicleReservation = vehicleReservation;
        this.paymentTimeStamp = new Date();
    }


    public double calculateAmount(){
        // TODO
        return 100.0;
    }
}
