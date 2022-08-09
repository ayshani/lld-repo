package org.cor.atmdispenser;

public class RupeeOneHundredDispenser implements DispenseChain{

    private DispenseChain nextChain;
    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.nextChain = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=100){
            int numberOfOneHundredNotes = currency.getAmount()/100;
            int remainingAmount = currency.getAmount()%100;

            System.out.println("Dispensing "+ numberOfOneHundredNotes+ " 100-Rupee notes");

            if(remainingAmount!=0)
                this.nextChain.dispense(new Currency(remainingAmount));
        } else
            this.nextChain.dispense(currency);
    }
}
