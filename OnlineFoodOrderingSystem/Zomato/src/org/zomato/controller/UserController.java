package org.zomato.controller;

import org.zomato.model.*;
import org.zomato.service.UserService;
import org.zomato.util.UserType;

import java.util.List;
import java.util.Optional;

public class UserController {
    private UserService userService;
    private RestaurantController restaurantController;

    public UserController(RestaurantController restaurantController){
        userService = new UserService();
        this.restaurantController = restaurantController;
    }

    public Customer addCustomer(String userName, String email){
        return (Customer) userService.addUser(userName, UserType.CUSTOMER, email);
    }

    public RestaurantManager addRestaurantManager(String userName, String email){
        return (RestaurantManager) userService.addUser(userName, UserType.RESTAURANT_MANAGER, email);
    }
    public User addAdmin(String userName, String email){
        return userService.addUser(userName, UserType.ADMIN, email);
    }

    public DeliverBoy addDriveryBoy(String userName, String email){
        return (DeliverBoy) userService.addUser(userName, UserType.DELIVERY_BOY, email);
    }

    public void markUserInactive(String userId){
        getUser(userId).markUserInactive();
    }

    public void markUserBlocked(String userId){
        getUser(userId).markUserBlocked();
    }

    public void markUserActive(String userId){
        getUser(userId).markUserActive();
    }

    public User getUser(String userId){
       return userService.findUserById(userId);
    }

    public List<DeliverBoy> getListOfDrivers(){
       return userService.getDeliveryBoyList();
    }

    public DeliverBoy findNearByDeliveryBoy(long latitude, long longitude){
        List<DeliverBoy> deliverBoys = getListOfDrivers();
        for(DeliverBoy boy : deliverBoys){
            if(boy.getLatitude() < latitude+5 && boy.getLatitude() > latitude-5 &&
                    boy.getLongitude() < longitude+5 && boy.getLongitude() > longitude-5){
                return boy;
            }
        }
        return null;
    }

    public void updateLocationOfDeliveryBoy(String deliveryBoyId, long latitude, long longitude){

        Optional<DeliverBoy> boy = getListOfDrivers().stream().
                filter(user -> user.getUserId().equals(deliveryBoyId))
                .findFirst();
        boy.ifPresent(deliverBoy -> deliverBoy.updateLocation(latitude, longitude));
    }

    public void addAddress(User user, Address address){
        userService.addAddress(user,address);
    }

    public List<Restaurant> searchByDish(User user, String dishName){
        return restaurantController.searchByDish(dishName);
    }

    public List<Restaurant> searchByName(User user, String restaurantName){
        return restaurantController.searchByRestaurantName(restaurantName);
    }

}
