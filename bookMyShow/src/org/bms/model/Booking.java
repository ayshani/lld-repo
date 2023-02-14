package org.bms.model;

import org.bms.exception.InvalidStateException;

import java.util.List;

public class Booking {

    private final String id;
    private final Show show;
    private final List<Seat> seatsBooked;
    private final String user;
    private BookingStatus bookingStatus;

    public Booking(String id, Show show, List<Seat> seatsBooked, String user) {
        this.id = id;
        this.show = show;
        this.seatsBooked = seatsBooked;
        this.user = user;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public boolean isConfirmed(){
        return this.bookingStatus ==  BookingStatus.CONFIRMED;
    }

    public void confirmBooking() {
        if(this.bookingStatus != BookingStatus.CREATED){
            throw new InvalidStateException();
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() throws InvalidStateException {
        if(this.bookingStatus != BookingStatus.CREATED){
            throw new InvalidStateException();
        }
        this.bookingStatus = BookingStatus.EXPIRED;
    }
}
