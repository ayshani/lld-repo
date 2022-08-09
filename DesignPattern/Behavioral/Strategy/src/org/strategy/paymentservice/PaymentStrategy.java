package org.strategy.paymentservice;

public interface PaymentStrategy {

    public boolean validate();
    public void pay(int amount);
}
