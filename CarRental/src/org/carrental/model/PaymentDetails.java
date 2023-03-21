package org.carrental.model;

import org.carrental.util.PaymentMode;

import java.util.Date;

public class PaymentDetails {
    String paymentId;
    int amountPaid;
    Date dateOfPayment;
    boolean isRefundable;
    PaymentMode paymentMode;
}
