package org.zomato.service;

import org.zomato.model.Bill;
import org.zomato.model.Payment;
import org.zomato.util.PaymentStatus;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private Map<String, Payment> payments;

    public PaymentService(){
        payments = new HashMap<>();
    }

    public Payment makePayment(Bill bill){
        Payment payment = new Payment(bill);
        payment.setPaymentStatus(PaymentStatus.IN_PROGRESS);
        payment.pay();
        payment.setPaymentStatus(PaymentStatus.SUCCESSFUL);
        payments.put(payment.getPaymentId(),payment);
        return  payment;
    }
}
