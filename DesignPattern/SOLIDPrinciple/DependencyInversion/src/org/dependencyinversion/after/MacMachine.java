package org.dependencyinversion.after;



public class MacMachine {
    private final Keyboard keyboard;
    private final Monitor monitor;

    // Here we are decoupling our machine by adding a more general Keyboard/Monitor interface
    // and at runtime, inject the concrete implementation(WirelessKeyboard/MechanicalKeyboard) to the interface
    // via constructor Or via setter
    // same goes for Monitor too
    public MacMachine(Keyboard keyboard,Monitor monitor ){
        this.keyboard = keyboard;
        this.monitor =  monitor;
    }
}
