package org.bms.services;

import org.bms.exception.BadRequestException;
import org.bms.exception.NotFoundException;
import org.bms.exception.SeatPermanentLyUnavailableException;
import org.bms.model.Booking;
import org.bms.model.BookingStatus;
import org.bms.model.Seat;
import org.bms.model.Show;
import org.bms.providers.SeatLockProvider;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {
    private final Map<String, Booking> showBookings;
    private final SeatLockProvider seatLockProvider;

    public BookingService(SeatLockProvider seatLockProvider){
        this.seatLockProvider  = seatLockProvider;
        this.showBookings = new HashMap<>();
    }

    public Booking getBooking(String bookingId){
        if(!showBookings.containsKey(bookingId))
            throw new NotFoundException();
        return showBookings.get(bookingId);
    }

    public List<Booking> getAllBookings(Show show){
        List<Booking> bookings = new ArrayList<>();
        for( Booking booking : showBookings.values()){
            if(booking.getShow().equals(show))
                bookings.add(booking);
        }
        return bookings;
    }

    public Booking createBooking(String userId, Show show, List<Seat> seats){
        if(isAnySeatAlreadyBooked(show, seats))
            throw new SeatPermanentLyUnavailableException();
        seatLockProvider.lockSeats(show,seats, userId);
        String bookingId = UUID.randomUUID().toString();
        Booking newBooking = new Booking(bookingId,show,seats,userId);
        showBookings.put(bookingId,newBooking);
        return newBooking;
    }

    public void confirmedBooking(Booking booking, String user){
        if(!booking.getUser().equals(user))
            throw new BadRequestException();

        for(Seat seat : booking.getSeatsBooked()){
            if(!seatLockProvider.validateLock(booking.getShow(),seat,user)){
                throw new BadRequestException();
            }
        }
        booking.confirmBooking();
    }

    public List<Seat> getBookedSeats(Show show){
        return getAllBookings(show).stream()
                .filter(Booking::isConfirmed)
                .map(Booking::getSeatsBooked)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private boolean isAnySeatAlreadyBooked(Show show, List<Seat> seats) {
        List<Seat> bookedSeats = getBookedSeats(show);
        for(Seat seat : seats){
            if(bookedSeats.contains(seat))
                    return true;
        }
        return false;
    }
}
