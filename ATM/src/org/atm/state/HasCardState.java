package org.atm.state;

import org.atm.ATM;
import org.atm.model.Card;

public class HasCardState extends ATMState {
    private ATM ATMInstance;
    public HasCardState(ATM atmInstance) {
        this.ATMInstance = atmInstance;
    }

    @Override
    public void authenticatePin(Card card, int pin){
        boolean isCorrectPinEntered = card.validatePIN(pin);
        if(isCorrectPinEntered){
            System.out.println("Card is Authenticated...");
            ATMInstance.setCurrentATMState(new SelectOperationState(ATMInstance));
        } else{
            System.out.println("Invalid PIN NUmber");
            exit();
        }
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
}


