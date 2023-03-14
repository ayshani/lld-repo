package org.command;

public class Light {

    private boolean switchedOn = false;

    public void switchOn(){
        System.out.println("Switching on light");
        this.switchedOn = true;
    }

    public void switchOff(){
        System.out.println("Switching off light");
        this.switchedOn = false;
    }

    public boolean isSwitchedOn(){

        return switchedOn;
    }
}
