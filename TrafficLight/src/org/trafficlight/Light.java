package org.trafficlight;

import lombok.Getter;

@Getter
public class Light {
    private Color color;
    private State currentState;
    private int timeDuration;

    public Light(Color color){
        this.color = color;
        this.currentState = State.OFF;
        this.timeDuration = 0;
    }

    public Light(Color color, int timeDuration){
        this.color = color;
        this.currentState = State.OFF;
        this.timeDuration = timeDuration;
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
