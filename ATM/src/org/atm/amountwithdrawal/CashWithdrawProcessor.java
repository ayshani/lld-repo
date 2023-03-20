package org.atm.amountwithdrawal;

import org.atm.ATM;

public abstract class CashWithdrawProcessor {

    CashWithdrawProcessor nextCashWithdrawProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
        this.nextCashWithdrawProcessor = nextCashWithdrawProcessor;
    }

    public  abstract void withdraw(ATM ATMInstance, int remainingAmount);
}
