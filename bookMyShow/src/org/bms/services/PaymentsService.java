package org.bms.services;

import org.bms.exception.BadRequestException;
import org.bms.model.Booking;
import org.bms.providers.SeatLockProvider;

import java.util.HashMap;
import java.util.Map;

public class PaymentsService {
    Map<Booking, Integer> bookingFailures;
    private final Integer allowedRetries;
    private final SeatLockProvider seatLockProvider;

    public PaymentsService(final Integer allowedRetries, SeatLockProvider seatLockProvider) {
        this.allowedRetries = allowedRetries;
        this.seatLockProvider = seatLockProvider;
        this.bookingFailures = new HashMap<>();
    }

    public void processPaymentFailed(final Booking booking, final String user){
        if(!booking.getUser().equals(user)){
            throw new BadRequestException();
        }
        bookingFailures.put(booking, bookingFailures.getOrDefault(booking,0)+1);
        if(bookingFailures.get(booking)> allowedRetries){
            seatLockProvider.unlockSeats(booking.getShow(),booking.getSeatsBooked(),user);
        }
    }
}
