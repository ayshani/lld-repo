package org.builder.carwithseperatebuilder;

public class Director {

    public void buildBugatti(CarBuilder carBuilder){
        carBuilder.setModel("Bugatti")
                .setColor("Blue")
                .setEngine("PS4")
                .setHeight(3)
                .setId(123)
                .setNoOfDoors(2);
    }

    public void buildLambo(CarBuilder carBuilder){
        carBuilder.setModel("Lambo")
                .setColor("Yellow")
                .setHeight(6)
                .setId(2)
                .setNoOfDoors(2);
    }
}
