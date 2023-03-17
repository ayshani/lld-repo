package org.atm.state;

import org.atm.ATM;

public class IdleState extends ATMState{

    private ATM ATMInstance;

    public IdleState(ATM ATMInstance){
        this.ATMInstance = ATMInstance;
    }

}
