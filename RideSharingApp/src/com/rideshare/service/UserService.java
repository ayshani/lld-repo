package com.rideshare.service;

import com.rideshare.model.Gender;
import com.rideshare.model.User;
import com.rideshare.model.Vehicle;
import com.rideshare.repo.UserRepository;
import com.rideshare.repo.VehicleRepository;

import java.util.Optional;

public class UserService {

    private static UserRepository userRepository;
    private static VehicleRepository vehicleRepository;

    public UserService(){
        userRepository = new UserRepository();
        vehicleRepository = new VehicleRepository();
    }

    public static User createUser(String name, int age, Gender gender){
        User user = new User(name,gender,age);
        userRepository.getAllUsers().add(user);

        return user;
    }

    public static Vehicle addVehicle(String owner, String model, String regNo){
        User user = getUserByName(owner);
        if(null == user)
            return null;
        Vehicle vehicle = new Vehicle(user,model,regNo);
        user.addVehcile(vehicle);
        vehicleRepository.getAllVehicles().add(vehicle);

        return vehicle;
    }

    public static User getUserByName(String name){
        return userRepository.getAllUsers().stream().
                filter(u -> u.getName().equals(name)).findAny().orElse(null);
    }

    public static Vehicle getVehicleByRegNo(String regNo){
        return vehicleRepository.getAllVehicles().stream().
                filter(v -> v.getRegistrationNumber().equals(regNo)).findAny().orElse(null);
    }

    public static User getUserByNameAndRegNo(String name,String regNo){
        Vehicle vehicle = getVehicleByRegNo(regNo);
        if(vehicle == null)
            return null;

         return userRepository.getAllUsers().stream().
                 filter( u-> u.getName().equals(name) && u.hasVehicle(vehicle)).
                 findAny().orElse(null);

    }
}
