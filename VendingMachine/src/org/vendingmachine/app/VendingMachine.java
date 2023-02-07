package org.vendingmachine.app;

import lombok.Getter;
import lombok.Setter;
import org.vendingmachine.inventory.Inventory;
import org.vendingmachine.inventory.Product;
import org.vendingmachine.states.CoinInsertedState;
import org.vendingmachine.states.DispenseState;
import org.vendingmachine.states.NoCoinInsertedState;
import org.vendingmachine.states.State;

//@Getter
//@Setter
public class VendingMachine {

    private NoCoinInsertedState noCoinInsertedState;
    private CoinInsertedState coinInsertedState;
    private DispenseState dispenseState;
    private State currentVendingMachineState;
    private Inventory inventory;
    private double amount;
    private static final int AISLE_COUNT = 10;

    public VendingMachine(){
        noCoinInsertedState = new NoCoinInsertedState(this);
        coinInsertedState =  new CoinInsertedState(this);
        dispenseState =  new DispenseState(this);
        this.currentVendingMachineState = noCoinInsertedState;
        amount = 0.0;
        inventory = new Inventory(AISLE_COUNT);
    }

    public boolean hasSufficientAmount(double expectedAmount){
        return expectedAmount <= this.amount;
    }

    public void insertCoin(double amount){
        this.currentVendingMachineState.insertCoin(amount);
        System.out.println(amount + " coin is inserted");
    }

    /*
    current state is COinInsertedState
    Once pressButton method is called, state changes to DispenseState
    And when dispense() method is called next line, the state is DispenseState.
    Hence the state transition happens here.
     */
    public void pressButton(int aisleNumber){
        this.currentVendingMachineState.pressButton(aisleNumber);
        this.currentVendingMachineState.dispense(aisleNumber);
    }

    public void addProduct(Product product){
        try{
            this.getInventory().addProduct(product);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setNoCoinInsertedState(NoCoinInsertedState noCoinInsertedState) {
        this.noCoinInsertedState = noCoinInsertedState;
    }

    public void setCoinInsertedState(CoinInsertedState coinInsertedState) {
        this.coinInsertedState = coinInsertedState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public void setCurrentVendingMachineState(State currentVendingMachineState) {
        this.currentVendingMachineState = currentVendingMachineState;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public NoCoinInsertedState getNoCoinInsertedState() {
        return noCoinInsertedState;
    }

    public CoinInsertedState getCoinInsertedState() {
        return coinInsertedState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public State getCurrentVendingMachineState() {
        return currentVendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public double getAmount() {
        return amount;
    }
}
