package org.trafficlight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LightMediator {
    private Map<Color,Light> lightMap;
    public LightMediator(){
        lightMap = new HashMap<>();
    }

    /**
     * register passed light object in LightMediator
     * It is being called by constructor of Light class.
     * We can also explicitly call this method.
     */
    public void registerLight(Light light){
        lightMap.put(light.getColor(),light);
    }

    /**
     * unregisters light from LightMediator
     */
    public void unregisterLight(Light light){
        lightMap.remove(light.getColor(),light);
    }

    public void turnOffAllOtherLights(Light currentLight){

        for(Light light: lightMap.values()){
            if(!light.equals(currentLight)){
                System.out.println("Turning off Light :"+ light.getColor());
                light.turnOFF();
            }
        }
    }

    public void turnONLight(Color color){
        turnONLight(lightMap.get(color));
    }

    public void turnONLight(Light light){
        System.out.println("Turning on Light :"+ light.getColor());
        turnOffAllOtherLights(light);
        light.turnON();
        System.out.println("Light : "+ light.getColor() + " is ON and status : "+ light.getCurrentState());
        System.out.println("------------------------------");
    }
}
