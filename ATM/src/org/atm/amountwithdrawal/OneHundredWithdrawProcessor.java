package org.atm.amountwithdrawal;

import org.atm.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{
    public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM ATMInstance, int remainingAmount) {
        int required = remainingAmount / 100;
        int balance = remainingAmount % 100;

        if (balance != 0) {
            System.out.println("Unable to dispatch.. Denominations are not available");
        }
        if (required <= ATMInstance.getNoOfOneHundredNotes()) {
            ATMInstance.deductOneHundredNotes(required);
        } else if (required > ATMInstance.getNoOfOneHundredNotes()) {
            System.out.println("Unable to dispatch.. Not enough Notes are available");
            throw new RuntimeException("Not enough notes");
        }
        if(required !=0) {
            System.out.println("Dispatching required notes : " + required + " of 100 denominations");
        }
    }
}
