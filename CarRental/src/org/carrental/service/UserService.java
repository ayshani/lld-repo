package org.carrental.service;

import org.carrental.model.User;
import org.carrental.model.VehicleReservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<String, User> userMap;
    private Map<User, List<VehicleReservation>> userReservationMap;


    public UserService(){
        userReservationMap =  new HashMap<>();
        userMap = new HashMap<>();
    }

    public void addUser(User user){
        this.userMap.put(user.getAccountId(),user);
    }

    public User getUser(String userId){
        return userMap.get(userId);
    }

    public void addUserReservation(User user, VehicleReservation vehicleReservation){
        userReservationMap.putIfAbsent(user,new ArrayList<>());
        userReservationMap.get(user).add(vehicleReservation);
    }

    public List<VehicleReservation> findReservationsByUser(User user){
        if(userReservationMap.get(user) != null)
            return userReservationMap.get(user);
        return List.of();
    }
}
