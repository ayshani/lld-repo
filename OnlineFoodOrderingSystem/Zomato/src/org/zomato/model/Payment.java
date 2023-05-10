package org.zomato.model;

import lombok.Getter;
import lombok.Setter;
import org.zomato.util.PaymentStatus;

import java.util.UUID;

@Getter
public class Payment {

    private String paymentId;
    private Bill bill;
    @Setter
    private PaymentStatus paymentStatus;

    public Payment(Bill bill){
        this.paymentId = UUID.randomUUID().toString();
        this.bill =bill;
        this.paymentStatus = PaymentStatus.NOT_STARTED;

    }

    public void pay() {
        System.out.println(bill.getCart().getCustomer().getUserName() + " paid Rs. "+ bill.getBillPrice());
    }
}
