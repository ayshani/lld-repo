package org.carrental;

import org.carrental.model.Bill;
import org.carrental.model.Location;
import org.carrental.model.User;
import org.carrental.model.VehicleReservation;
import org.carrental.service.PaymentService;
import org.carrental.service.Store;
import org.carrental.service.UserService;

import java.util.*;

public class CarRentalApp {
    private Map<String,Store> stores;
    private PaymentService paymentService;
    private UserService userService;

    public CarRentalApp(){
        this.stores =  new HashMap<>();
        this.paymentService = new PaymentService();
        this.userService =  new UserService();
    }

    // User related services
    public void addUser(User user){
        userService.addUser(user);
    }

    public User findUserById(String accountId){
        return userService.getUser(accountId);
    }

    public List<VehicleReservation> findReservationsByUser(User user){
        return userService.findReservationsByUser(user);
    }

    //handling store
    public Store addStore(Location location){
        Store store = new Store(location,userService);
        stores.put(store.getStoreId(),store);
        return store;
    }

    public Store getStoreById(String storeId){
        return stores.get(storeId);
    }


    // reservation methods
    public VehicleReservation reserveVehicle(String storeId, String userId,  Date startDate, Date endDate, String pickUpLocation, String returnLocation){
        Store store = stores.get(storeId);
        User user =  findUserById(userId);
        return store.reserveVehicle(user,startDate,endDate,pickUpLocation,returnLocation);
    }

    public void cancelReservation(String storeId, String reservationId){
        Store store = stores.get(storeId);
        store.cancelReservation(reservationId);
    }

    public void startTrip(String storeId, String reservationId){
        Store store = stores.get(storeId);
        store.startTrip(reservationId);
    }

    public void endTrip(String storeId, String reservationId){
        Store store = stores.get(storeId);
        store.endTrip(reservationId);
    }

    public boolean makePayment(VehicleReservation vehicleReservation){
        paymentService.setBill(new Bill(vehicleReservation));
        return paymentService.makePayment();
    }
}
