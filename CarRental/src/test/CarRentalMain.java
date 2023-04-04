package test;

import org.carrental.CarRentalApp;
import org.carrental.model.Location;
import org.carrental.model.User;
import org.carrental.model.Vehicle;
import org.carrental.model.VehicleReservation;
import org.carrental.service.Store;
import org.carrental.util.VehicleType;

import java.time.LocalDateTime;
import java.util.Date;

//https://github.com/kumaransg/LLD/blob/main/Low_level_Problem_set_2/cabBooking2/Driver.java
//https://www.youtube.com/watch?v=J4GO6hmR6TA&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=13
public class CarRentalMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Car Rental Service !");

        CarRentalApp carRentalApp =  new CarRentalApp();

        User user1 =  new User("Ashok","22B Baker Street","ashok@gmail.com",587587,"abc", "734687964798asd",new Date());
        User user2 =  new User("Bijlani","2 Louden Street","Bijlani@gmail.com",637911,"huigi","734687964798asd",new Date());
        carRentalApp.addUser(user1);
        carRentalApp.addUser(user2);

        Store storeA = carRentalApp.addStore(new Location("Kolkata-South"));
        Store storeB = carRentalApp.addStore(new Location("Kolkata-North"));

        System.out.println(carRentalApp.findUserById(user1.getAccountId()));
        System.out.println(carRentalApp.getStoreById(storeA.getStoreId()));

        Vehicle vehicleA = new Vehicle(894923649, VehicleType.BIKE, 100,50,2);
        Vehicle vehicleB = new Vehicle(423544336, VehicleType.CAR, 101,51,4);
        Vehicle vehicleC = new Vehicle(455654747, VehicleType.CAR, 200,10,4);
        Vehicle vehicleD = new Vehicle(42354, VehicleType.CAR, 101,51,4);
        Vehicle vehicleE = new Vehicle(234534, VehicleType.CAR, 200,10,4);

        storeA.addVehicleToStore(vehicleA);
        storeA.addVehicleToStore(vehicleB);
        storeA.addVehicleToStore(vehicleE);
        storeB.addVehicleToStore(vehicleC);
        storeB.addVehicleToStore(vehicleD);


        VehicleReservation vehicleReservationByA =
                carRentalApp.reserveVehicle(storeA.getStoreId(),
                                            user1.getAccountId(),
                        LocalDateTime.now(),LocalDateTime.now().plusDays(5), "Barasat","NewTown");

        carRentalApp.makePayment(vehicleReservationByA);

        VehicleReservation vehicleReservationByB=
                carRentalApp.reserveVehicle(storeA.getStoreId(),
                        user1.getAccountId(),
                        LocalDateTime.now(),LocalDateTime.now().plusDays(5).plusHours(4), "Kolkata","Hyd");

        carRentalApp.makePayment(vehicleReservationByB);
        VehicleReservation vehicleReservationByC =
                carRentalApp.reserveVehicle(storeA.getStoreId(),
                        user2.getAccountId(),
                        LocalDateTime.now(),LocalDateTime.now().plusDays(6).plusHours(6), "Barasat","NewTown");

        carRentalApp.makePayment(vehicleReservationByC);

        // Below Reservation wont happen as three cars of storeA are booked already
        /*VehicleReservation vehicleReservationByD =
                carRentalApp.reserveVehicle(storeA.getStoreId(),
                        user2.getAccountId(),
                        new Date(),new Date(), "Kolkata","Hyd");

         */
        carRentalApp.startTrip(storeA.getStoreId(),vehicleReservationByA.getReservationId());
        System.out.println("Vehicle status after start trip : "+ vehicleReservationByA.getVehicle().getVehicleStatus());
        carRentalApp.endTrip(storeA.getStoreId(),vehicleReservationByA.getReservationId());
        System.out.println("Vehicle status after start trip : "+ vehicleReservationByA.getVehicle().getVehicleStatus());

        //Trying to book again . One vehicle is available as teh last trip ended
        VehicleReservation vehicleReservationByD =
                carRentalApp.reserveVehicle(storeA.getStoreId(),
                        user2.getAccountId(),
                        LocalDateTime.now(),LocalDateTime.now().plusDays(10).plusHours(2), "Kolkata","Hyd");

        carRentalApp.makePayment(vehicleReservationByD);
    }

    // To Do
    // Calculate Amount - Hourly , Daily -- done
    // Proper print message in make Payment -- done

    // Next Backlog To Do
    // ATM - Proper Prints - Mainly in Dispatch - done
    // BookMyShow : Main One Use Case
}