package org.zomato.service;

import lombok.Getter;
import org.zomato.model.*;
import org.zomato.util.UserType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class UserService {
    private Map<String, User> users;

    public UserService(){
        this.users = new HashMap<>();
    }

    public User addUser(String userName, UserType userType, String email){
        User user = null;
        switch (userType){
            case CUSTOMER ->
            {
                user = new Customer(userName,email);
                this.users.putIfAbsent(user.getUserId(), user);
                return (Customer)user;

            }
            case DELIVERY_BOY -> {
                user = new DeliverBoy(userName,email);
                this.users.putIfAbsent(user.getUserId(), user);
                return (DeliverBoy)user;
            }
            case RESTAURANT_MANAGER -> {
                user = new RestaurantManager(userName,email);
                this.users.putIfAbsent(user.getUserId(), user);
                return (RestaurantManager)user;
            }default -> {
                user = new User(userName,UserType.ADMIN,email);
                this.users.putIfAbsent(user.getUserId(), user);
                return  user;
            }
        }
    }

    public User findUserById(String id){
        User user = users.get(id);
        return user;
    }

    public void addAddress(User user, Address address){
        if(!users.containsKey(user.getUserId())){
            System.out.println("User is not present");
            return;
        }
        user.addAddress(address);
    }

    public List<DeliverBoy> getDeliveryBoyList(){
        return new ArrayList<>(users.values())
                .stream()
                .filter(user -> user instanceof DeliverBoy)
                .map(user -> (DeliverBoy)user)
                .collect(Collectors.toList());
    }
}
