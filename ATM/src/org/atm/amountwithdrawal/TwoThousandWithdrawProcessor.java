package org.atm.amountwithdrawal;

import org.atm.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor{

    public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM ATMInstance, int remainingAmount) {
        int required = remainingAmount/2000;
        int balance = remainingAmount%2000;

        if(required<=ATMInstance.getNoOfTwoThousandNotes()){
            ATMInstance.deductTwoThousandNotes(required);
        } else if(required> ATMInstance.getNoOfTwoThousandNotes()){
            // if required number of 2000 Rs notes are more than notes available in ATM
            // we add again the balance in ATM. Once it is done, we deduct
            // the number of 2000 Rs notes from ATM
            balance += (required-ATMInstance.getNoOfTwoThousandNotes())*2000;
            ATMInstance.deductTwoThousandNotes(ATMInstance.getNoOfTwoThousandNotes());
        }
        if(required !=0) {
            System.out.println("Dispatching required notes : " + required + " of 2000 denominations");
        }
        if(balance!=0){
            nextCashWithdrawProcessor.withdraw(ATMInstance,balance);
        }
    }
}
