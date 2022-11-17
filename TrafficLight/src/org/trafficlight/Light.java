package org.trafficlight;

import lombok.Getter;

@Getter
public class Light {
    private Color color;
    private State currentState;

    public Light(Color color){
        this.color = color;
        this.currentState = State.OFF;
    }

    public void turnON(){
        this.currentState = State.ON;
    }

    public void turnOFF(){
        this.currentState = State.OFF;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Light){
            return this.color.equals(((Light) object).color);
        }
        return false;
    }
}
