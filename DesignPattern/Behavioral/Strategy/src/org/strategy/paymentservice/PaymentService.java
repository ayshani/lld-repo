package org.strategy.paymentservice;

public class PaymentService {
    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.setPaymentStrategy(paymentStrategy);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(int amount){
        this.paymentStrategy.pay(amount);
    }
}
