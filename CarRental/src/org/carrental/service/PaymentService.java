package org.carrental.service;

import lombok.Getter;
import lombok.Setter;
import org.carrental.model.Bill;

@Getter
@Setter
public class PaymentService {

    private Bill bill;

    public PaymentService(){
    }

    public boolean makePayment(){
        System.out.println("Making payment of "+ bill.calculateAmount() );
        return true;
    }
}
