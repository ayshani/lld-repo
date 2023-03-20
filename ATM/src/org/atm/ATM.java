package org.atm;

import org.atm.state.ATMState;
import org.atm.state.IdleState;

public class ATM {

    // only one instance of ATM
    private static volatile ATM ATMInstance;
    private ATMState ATMState;
    private int ATMBalance;
    private int noOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int noOfOneHundredNotes;
    private ATM(){
    }

    // creating SingleTon instance
    public static ATM getInstance(){
        if(ATMInstance== null){
            synchronized (ATM.class){
                if(ATMInstance== null){
                    ATMInstance = new ATM();
                    ATMInstance.setCurrentATMState(new IdleState(ATMInstance));
                }
            }
        }
        return ATMInstance;
    }

    public ATMState getCurrentATMState() {
        return ATMState;
    }

    public int getATMBalance() {
        return ATMBalance;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void setCurrentATMState(ATMState ATMState) {
        this.ATMState = ATMState;
    }

    public void setATMBalance(int ATMBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.ATMBalance = ATMBalance;
        this.noOfFiveHundredNotes=noOfFiveHundredNotes;
        this.noOfOneHundredNotes= noOfOneHundredNotes;
        this.noOfTwoThousandNotes =  noOfTwoThousandNotes;
    }

    public void deductTwoThousandNotes(int number){
        this.noOfTwoThousandNotes -= number;
    }

    public void deductFiveHundredNotes(int number){
        this.noOfFiveHundredNotes -= number;
    }

    public void deductOneHundredNotes(int number){
        this.noOfOneHundredNotes -= number;
    }

    public void deductATMBalance(int amount){
        this.ATMBalance -=amount;
    }

    public void printCurrentATMBalnace(){
        System.out.println("Balance: " + ATMBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }
}
