package org.cor.atmdispenser;

public class RupeeTwoHundredDispenser implements DispenseChain {

    private DispenseChain nextChain;
    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.nextChain = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=200){
            int numberOfTwoHundredNotes = currency.getAmount()/200;
            int remainingAmount = currency.getAmount()%200;

            System.out.println("Dispensing "+ numberOfTwoHundredNotes+ " 200-Rupee notes");

            if(remainingAmount!=0)
                this.nextChain.dispense(new Currency(remainingAmount));
        } else
            this.nextChain.dispense(currency);
    }
}
