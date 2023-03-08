package org.builder.carwithseperatebuilder;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-creational-builder/src/main/java/com/youtube/geekific/MainApp.java
//https://www.youtube.com/watch?v=MaY_MDdWkQw
public class CarApp {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();
        director.buildBugatti(carBuilder);
        System.out.println(carBuilder.setColor("Red").build());

        CarBuilder lamboBuilder = new CarBuilder();
        director.buildLambo(lamboBuilder);
        System.out.println(lamboBuilder.setColor("black").build());
    }
}