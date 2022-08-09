package org.cor.atmdispenser;

import java.util.Scanner;

// https://www.digitalocean.com/community/tutorials/chain-of-responsibility-design-pattern-in-java
public class ATMDispenserApplication {

    private DispenseChain mainDispenser;
    public ATMDispenserApplication(){
        // initialize the chain
        mainDispenser = new RupeeFiveHundredDispenser();
        DispenseChain twoHundredDispenser = new RupeeTwoHundredDispenser();
        DispenseChain OneHundredDispenser = new RupeeOneHundredDispenser();

        // set the chain of responsibility
        mainDispenser.setNextChain(twoHundredDispenser);
        twoHundredDispenser.setNextChain(OneHundredDispenser);

    }

    public static void main(String[] args) {
        ATMDispenserApplication atmDispenser = new ATMDispenserApplication();


        int amount =0;
        System.out.println("Enter amount");
        Scanner input = new Scanner(System.in);

        amount = input.nextInt();

        if(amount%100 !=0){
            System.out.println("Amount should be in multiple of 100s.");
            return;
        }

        // process the request
        atmDispenser.mainDispenser.dispense(new Currency(amount));

    }
}
