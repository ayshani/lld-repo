package org.interfacesegregation.before;

public class Cleaner implements RestaurantEmployee{
    @Override
    public void washDishes() {
        // This is my Job.
    }

    @Override
    public void cookFood() {
        //I am not gonna do this. Not my job.
    }

    @Override
    public void serveCustomers() {
        //I am not gonna do this. Not my job.
    }
}
