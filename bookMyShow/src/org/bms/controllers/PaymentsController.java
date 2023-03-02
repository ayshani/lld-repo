package org.bms.controllers;

import lombok.AllArgsConstructor;
import org.bms.services.BookingService;
import org.bms.services.PaymentsService;

@AllArgsConstructor
public class PaymentsController {
    private final PaymentsService paymentsService;
    private final BookingService bookingService;

    public void handlePaymentFailure(String bookingId, String user){
        paymentsService.processPaymentFailed(bookingService.getBooking(bookingId),user);
    }

    public void handlePaymentSuccess(String bookingId, String user){
        bookingService.confirmedBooking(bookingService.getBooking(bookingId),user);
    }
}
