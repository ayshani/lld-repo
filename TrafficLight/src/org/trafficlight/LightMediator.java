package org.trafficlight;

import java.util.HashSet;
import java.util.List;

public class LightMediator {

    private HashSet<Light> lights;

    public LightMediator(){
        lights = new HashSet<>();
    }

    /**
     * register passed light object in LightMediator
     * It is being called by constructor of Light class.
     * We can also explicitly call this method.
     */
    public void registerLight(Light light){
        lights.add(light);
    }

    /**
     * unregisters light from LightMediator
     */
    public void unregisterLight(Light light){
        lights.remove(light);
    }

    public void turnOffAllOtherLights(Light currentLight){
        for(Light light : lights){
            if(!light.equals(currentLight)){
                System.out.println("Turning off Light :"+ light.getColor());
                light.turnOFF();
            }
        }

    }

    public void turnONLight(Light light){
        System.out.println("Turning on Light :"+ light.getColor());
        turnOffAllOtherLights(light);
        light.turnON();
        System.out.println("Light : "+ light.getColor() + " is ON and status : "+ light.getCurrentState());
        System.out.println("------------------------------");
    }
}
