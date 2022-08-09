package org.strategy.paymentservice;

public class PayPalStrategy implements PaymentStrategy{

    private String username;
    private String password;

    public PayPalStrategy(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate() {
        System.out.println("Paypal Account is validated");
        return true;
    }

    @Override
    public void pay(int amount) {
        validate();
        System.out.println("Amount "+ amount+" paid using Paypal");
    }
}
