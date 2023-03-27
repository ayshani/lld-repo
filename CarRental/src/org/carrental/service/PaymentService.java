package org.carrental.service;

import lombok.Getter;
import lombok.Setter;
import org.carrental.model.Payment;
import org.carrental.util.PaymentMode;

@Getter
@Setter
public class PaymentService {

    private Payment payment;

    public PaymentService(){
    }

    public boolean makePayment(){
        System.out.println("Making payment of "+ payment.getAmount() );
        return true;
    }
}
