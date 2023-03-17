package org.atm.state;

import org.atm.model.Card;
import org.atm.model.TransactionType;

public abstract class ATMState {

    public void insertCard(Card card){
        System.out.print("Oops !! something went wrong..");
    }

    public void authenticatePin(Card card, int pin){
        System.out.print("Oops !! something went wrong..");
    }
    public void selectOperation(Card card, TransactionType transactionType){
        System.out.print("Oops !! something went wrong..");
    }

    public void cashWithdrawal(Card card, int withdrawalAmount){
        System.out.print("Oops !! something went wrong..");
    }

    public void displayBalance(Card card){
        System.out.print("Oops !! something went wrong..");
    }

    public void returnCard(){
        System.out.print("Oops !! something went wrong..");
    }

    public void exit(){
        System.out.print("Oops !! something went wrong..");
    }

}
