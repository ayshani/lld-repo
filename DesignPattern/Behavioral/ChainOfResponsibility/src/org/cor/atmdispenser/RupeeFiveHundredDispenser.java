package org.cor.atmdispenser;

public class RupeeFiveHundredDispenser implements DispenseChain{

    private DispenseChain nextChain;
    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.nextChain = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=500){
            int numberOfFiveHundredNotes = currency.getAmount()/500;
            int remainingAmount = currency.getAmount()%500;

            System.out.println("Dispensing "+ numberOfFiveHundredNotes+ " 500-Rupee notes");

            if(remainingAmount!=0)
                this.nextChain.dispense(new Currency(remainingAmount));
        } else
            this.nextChain.dispense(currency);
    }
}
