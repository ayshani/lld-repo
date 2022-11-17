package test;

import org.trafficlight.Color;
import org.trafficlight.Light;
import org.trafficlight.LightMediator;

public class TrafficLight {
    public static void main(String[] args) {


        LightMediator lightMediator = new LightMediator();
        Light green = new Light(Color.GREEN);
        Light red = new Light(Color.RED);
        Light yellow = new Light(Color.YELLOW);
        lightMediator.registerLight(green);
        lightMediator.registerLight(red);
        lightMediator.registerLight(yellow);

        lightMediator.turnONLight(green);
        lightMediator.turnONLight(yellow);
        lightMediator.turnONLight(red);
        lightMediator.turnONLight(yellow);
        lightMediator.turnONLight(green);
    }
}