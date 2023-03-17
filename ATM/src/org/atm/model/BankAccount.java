package org.atm.model;

import java.util.UUID;

public class BankAccount {
    String accountNumber;
    int balance;

    public BankAccount(int amount){
        this.accountNumber = UUID.randomUUID().toString();
        this.balance = amount;
    }

    public void withdraw(int amount){
        System.out.println("Withdrawing : updating bank account ");
        balance = balance-amount;
    }

    public int getBalance() {
        return balance;
    }
}
