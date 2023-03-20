package org.atm.model;

import java.util.Date;

public class Card {

    private final int cardNumber;
    private final int cvv;
    private final Date expiryDate;
    private final String holderName;
    private final int PIN;
    private BankAccount bankAccount;


    public Card(int cardNumber, int cvv, Date expiryDate, String holderName, int PIN, BankAccount bankAccount) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.holderName = holderName;
        this.PIN = PIN;
        this.bankAccount = bankAccount;
    }

    public boolean validatePIN(int pin){
        return PIN ==  pin;
    }

    public int getBalance(){
        return bankAccount.getBalance();
    }

    public void deductBalance(int amount){
        bankAccount.withdraw(amount);
    }
}
