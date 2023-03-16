package org.liskovsubstitution.animal.after;
public class Dog extends BarkableAnimal {

    @Override
    public void makeNoise() {
        System.out.println("bow wow");
    }
}
