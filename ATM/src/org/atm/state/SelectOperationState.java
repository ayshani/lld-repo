package org.atm.state;

import org.atm.ATM;
import org.atm.model.Card;
import org.atm.model.TransactionType;

public class SelectOperationState extends ATMState {
    private ATM ATMInstance;
    public SelectOperationState(ATM atmInstance) {
        this.ATMInstance = atmInstance;
        showOptions();
    }

    private void showOptions() {

        System.out.println("Please select the option :");
        TransactionType.showAllTransactionType();
    }

    @Override
    public void selectOperation(Card card, TransactionType transactionType){
        switch(transactionType){
            case CASH_WITHDRAWAL -> {
                ATMInstance.setCurrentATMState(new CashWithdrawalState(ATMInstance));
                break;
            }
            case BALANCE_CHECk -> {
                ATMInstance.setCurrentATMState(new CheckBalanceState(ATMInstance));
                break;
            }
            default -> {
                System.out.println("Invalid Option");
                exit();
                break;
            }
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
