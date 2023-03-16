package org.interfacesegregation.before;

public class Cook implements RestaurantEmployee{
    @Override
    public void washDishes() {
        //I am not gonna do this. Not my job.
    }

    @Override
    public void cookFood() {
        // This is my Job.
    }

    @Override
    public void serveCustomers() {
        //I am not gonna do this. Not my job.
    }
}
