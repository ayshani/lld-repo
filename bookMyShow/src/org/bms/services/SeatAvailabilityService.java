package org.bms.services;

import org.bms.model.Seat;
import org.bms.model.SeatLock;
import org.bms.model.Show;
import org.bms.providers.SeatLockProvider;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityService {
    final private BookingService bookingService;
    final private SeatLockProvider seatLockProvider;

    public SeatAvailabilityService(BookingService bookingService, SeatLockProvider seatLockProvider){
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(Show show){
        final List<Seat> allSeats = show.getScreen().getSeats();
        List<Seat> allBookedAndLockedSeats = getAllBookedAndLockedSeats(show);

        List<Seat> availableSeats = new ArrayList<>(allSeats);
        availableSeats.removeAll(allBookedAndLockedSeats);
        return availableSeats;
    }

    private List<Seat> getAllBookedAndLockedSeats(Show show) {
        List<Seat> unavailableSeats = bookingService.getBookedSeats(show);
        unavailableSeats.addAll(seatLockProvider.getLockedSeats(show));
        return unavailableSeats;
    }


}
