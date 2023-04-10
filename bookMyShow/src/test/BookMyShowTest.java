package test;


import org.bms.exception.SeatPermanentLyUnavailableException;
import org.bms.exception.SeatTemporaryUnavailableException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class BookMyShowTest  extends BaseTest{

    @BeforeEach
    public void setUp(){
        setupController(10,0);
    }
    @Test
    public void testCase(){
        String user1 = " User1", user2 = " User2";

        final String movie = movieController.createMovie("Movie1");
        final String screen = setupScreen();
        final List<String> screen1SeatIds = createSeats(theatreController,screen,2,10);
        final String show = showController.createShow(movie,screen,new Date(), 2*60*60);
        List<String> u1AvaialableSeats = showController.getAvailableSeats(show);
        validateSeatsList(u1AvaialableSeats,screen1SeatIds,List.of());

        List<String> u1SelectedSeats = List.of(
                screen1SeatIds.get(0),
                screen1SeatIds.get(2),
                screen1SeatIds.get(5),
                screen1SeatIds.get(10)
        );

        List<String> u2SelectedSeats = List.of(
                screen1SeatIds.get(0),
                screen1SeatIds.get(1),
                screen1SeatIds.get(2),
                screen1SeatIds.get(3)
        );

        final String u1BookingId = bookingController.createBooking(user1,show,u1SelectedSeats);
        Assertions.assertThrows(SeatTemporaryUnavailableException.class, ()->
        {
            final String u2BookingId = bookingController.createBooking(user2,show,u2SelectedSeats);
        });
        paymentsController.handlePaymentSuccess(u1BookingId,user1);
        Assertions.assertThrows(SeatPermanentLyUnavailableException.class, ()->
        {
            final String u2BookingId = bookingController.createBooking(user2,show,u2SelectedSeats);
        });
    }
}