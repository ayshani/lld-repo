package org.carrental.model;

import org.carrental.util.ReservationStatus;

import java.util.Date;

public class VehicleReservation {
    private String reservationId;
    private Vehicle vehicle;
    private User user;
    private ReservationStatus reservationStatus;
    private Date startDate;
    private Date endDate;
    private String pickUpLocation;
    private String returnLocation;

    // Below can be part of reservations
    // private List<Equipment> equipments; We can use Equipment(Eg : Navigation, ChildSeat, SkiRack) add Ons
    // private List<Service> services; Services(DriverService, RoadsideAssistance, WiFi) can be included
}
