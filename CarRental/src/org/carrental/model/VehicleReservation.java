package org.carrental.model;

import lombok.Getter;
import org.carrental.util.ReservationStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
public class VehicleReservation {
    private String reservationId;
    private Vehicle vehicle;
    private User user;
    private ReservationStatus reservationStatus;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Date dateOfReservation;
    private String pickUpLocation;
    private String returnLocation;


    // Below can be part of reservations
    // private List<Equipment> equipments; We can use Equipment(Eg : Navigation, ChildSeat, SkiRack) add Ons
    // private List<Service> services; Services(DriverService, RoadsideAssistance, WiFi) can be included


    public VehicleReservation(Vehicle vehicle, User user, LocalDateTime startDate, LocalDateTime endDate, Date dateOfReservation, String pickUpLocation, String returnLocation) {
        this.reservationId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateOfReservation = dateOfReservation;
        this.pickUpLocation = pickUpLocation;
        this.returnLocation = returnLocation;
        this.reservationStatus = ReservationStatus.PENDING;
    }

    public void updateReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
