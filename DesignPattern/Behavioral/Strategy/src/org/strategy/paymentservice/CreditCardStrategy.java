package org.strategy.paymentservice;

import java.util.Date;

public class CreditCardStrategy implements PaymentStrategy{

    private String cardHolderName;
    private long cardNumber;
    private int cvv;
    private Date expiryDate;

    public CreditCardStrategy(String cardHolderName, long cardNumber, int cvv, Date expiryDate) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean validate() {
        System.out.println("Credit Card is validated");
        return true;
    }

    @Override
    public void pay(int amount) {
        validate();
        System.out.println("Amount "+ amount+" paid using Credit Card");
    }
}
