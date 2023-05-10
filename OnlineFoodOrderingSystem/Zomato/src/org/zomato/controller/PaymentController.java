package org.zomato.controller;

import org.zomato.model.Bill;
import org.zomato.model.Payment;
import org.zomato.model.User;
import org.zomato.service.BillService;
import org.zomato.service.PaymentService;

public class PaymentController {

    private BillService billService;
    private PaymentService paymentService;

    public PaymentController(){
        billService = new BillService();
        paymentService = new PaymentService();
    }

    public Payment pay(User user){
        Bill bill = billService.generateCurrentBill(user.getUserCart());
        Payment payment = paymentService.makePayment(bill);
        return payment;
    }
}
