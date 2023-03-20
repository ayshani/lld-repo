package org.atm.amountwithdrawal;

import org.atm.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor {
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
       super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM ATMInstance, int remainingAmount) {
        int required = remainingAmount / 500;
        int balance = remainingAmount % 500;

        if (required <= ATMInstance.getNoOfFiveHundredNotes()) {
            ATMInstance.deductFiveHundredNotes(required);
        } else if (required > ATMInstance.getNoOfFiveHundredNotes()) {
            // if required number of 500 Rs notes are more than notes available in ATM
            // we add again the balance in ATM. Once it is done, we deduct
            // the number of 500 Rs notes from ATM
            balance += (required - ATMInstance.getNoOfFiveHundredNotes()) * 500;
            ATMInstance.deductFiveHundredNotes(ATMInstance.getNoOfFiveHundredNotes());
        }
        if (balance != 0) {
            nextCashWithdrawProcessor.withdraw(ATMInstance, balance);
        }
    }
}
