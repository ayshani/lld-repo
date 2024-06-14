package org.liskovsubstitution.animal.after;

public class Cat extends BarkableAnimal {

    @Override
    public void makeNoise() {
        System.out.println("meow meow");
    }
}
