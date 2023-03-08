package org.builder.carwithsamebuilder;

import org.builder.carwithseperatebuilder.Car;

public class CarWithBuilder {

    private  int id;
    private  int height;
    private  String model;
    private  String color;
    private  String engine;
    private  int noOfDoors;

    public Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private  int id;
        private  int height;
        private  String model;
        private  String color;
        private  String engine;
        private  int noOfDoors;

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setHeight(int height){
            this.height = height;
            return this;
        }
        public Builder setColor(String color){
            this.color = color;
            return this;
        }
        public Builder setEngine(String engine){
            this.engine = engine;
            return this;
        }
        public Builder setNoOfDoors(int noOfDoors){
            this.noOfDoors = noOfDoors;
            return this;
        }
        public Builder setModel(String model){
            this.model = model;
            return this;
        }

        public CarWithBuilder build(){
            if(this.engine == null){
                throw new RuntimeException("Engine is mandatory for Car");
            }
            CarWithBuilder car = new CarWithBuilder();
            car.id = this.id;
            car.height =this.height;
            car.color = this.color;
            car.engine = this.engine;
            car.model = this.model;
            car.noOfDoors = this.noOfDoors;
            return car;
        }

    }

    @Override
    public String toString() {
        return "CarWithBuilder{" +
                "id=" + id +
                ", height=" + height +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", noOfDoors=" + noOfDoors +
                '}';
    }
}
