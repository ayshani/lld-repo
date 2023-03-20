package org.atm.state;

import org.atm.ATM;
import org.atm.model.Card;

public class CheckBalanceState extends ATMState {
    private ATM ATMInstance;
    public CheckBalanceState(ATM atmInstance) {
        this.ATMInstance =atmInstance;
    }

    @Override
    public void exit() {
        returnCard();
        System.out.println("Exiting. Thank you. Visit Again !");
        ATMInstance.setCurrentATMState(new IdleState(ATMInstance));
    }

    @Override
    public void returnCard(){
        System.out.print("Please collect Your Card..");
    }

    @Override
    public void displayBalance(Card card){
        System.out.print("Your Balance is : "+ card.getBalance());
        exit();
    }
}
