package org.carrental.model;

import lombok.Getter;

import java.time.Duration;
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
        Duration duration = Duration.between(this.vehicleReservation.getStartDate(),this.vehicleReservation.getEndDate());
        long days = duration.toDays();
        long hours = duration.toHours();

        long leftHours =  hours -days*24;

        double totalAmount = (days * this.vehicleReservation.getVehicle().getDailyRentalCost() )
                            + (leftHours * this.vehicleReservation.getVehicle().getHourlyRentalCost());
        return totalAmount;
    }
}
