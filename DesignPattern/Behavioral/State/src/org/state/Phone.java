package org.state;

public class Phone {
    private State state;

    public Phone(){
        this.state = new OffState(this);
    }
    public void setState(State state){
        this.state = state;
    }

    public void turnOn(){
        System.out.println("Turning screen on, device is still locked.");
    }

    public void unlock(){
        System.out.println("Unlocking the phone to home");
    }

    public void lock(){
        System.out.println("Locking the phone");
    }

    public void off(){
        System.out.println("turning off the screen");
    }

    public void home() {
        System.out.println("Going to home screen");
    }

    public void clickPower(){
        state.onOffOn();
    }

    public void clickHome(){
        state.onHome();
    }
}
