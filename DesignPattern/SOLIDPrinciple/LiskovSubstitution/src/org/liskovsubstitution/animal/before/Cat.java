package org.liskovsubstitution.animal.before;

public class Cat extends Animal{

    @Override
    public void makeNoise() {
        System.out.println("meow meow");
    }
}
