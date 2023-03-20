package org.atm.state;

import org.atm.ATM;
import org.atm.amountwithdrawal.CashWithdrawProcessor;
import org.atm.amountwithdrawal.FiveHundredWithdrawProcessor;
import org.atm.amountwithdrawal.OneHundredWithdrawProcessor;
import org.atm.amountwithdrawal.TwoThousandWithdrawProcessor;
import org.atm.model.Card;

public class CashWithdrawalState extends ATMState {

    private ATM ATMInstance;
    public CashWithdrawalState(ATM atmInstance) {
        this.ATMInstance = atmInstance;
    }

    public void cashWithdrawal(Card card, int withdrawalAmount){
        if(ATMInstance.getATMBalance()<withdrawalAmount){
            System.out.print("Insufficient fund in the ATM Machine..");
            exit();
        }
        else if(card.getBalance()<withdrawalAmount){
            System.out.print("Insufficient fund in your Bank Account..");
            exit();
        } else{
            card.deductBalance(withdrawalAmount);
            ATMInstance.deductATMBalance(withdrawalAmount);

            CashWithdrawProcessor cashWithdrawProcessor = new TwoThousandWithdrawProcessor
                    (new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
            cashWithdrawProcessor.withdraw(ATMInstance, withdrawalAmount);
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
