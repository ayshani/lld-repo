package org.dependencyinversion.before;


public class MacMachine {
    private final Keyboard keyboard;
    private final Monitor monitor;

    public MacMachine(){
        //By declaring the StandardKeyboard and Monitor with the new keyword,
        // we've tightly coupled these three classes together.

        //Not only does this make our MacMachine hard to test, but we've also lost the ability
        // to switch out our LCDKeyboard class with a different one should the need arise.
        // And we're stuck with our Monitor class too.

        // One solution is to decouple our machine adding a more general Keyboard/Monitor interface
        // at runtime inject the concrete implementation(WirelessKeyboard/MechanicalKeyboard) to the interface
        // via constructor Or via setter
        // same goes for Monitor too
        keyboard = new WiredKeyboard();
        monitor =  new LCDMonitor();
    }
}
