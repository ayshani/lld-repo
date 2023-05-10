package org.zomato.controller;

import org.zomato.model.Restaurant;
import org.zomato.model.RestaurantManager;
import org.zomato.service.RestaurantService;
import org.zomato.util.RestaurantStatus;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestaurantController {
    private RestaurantService restaurantService;
    public RestaurantController(){
        this.restaurantService = new RestaurantService();
    }

    public Restaurant addRestaurant(String restaurantName, long latitude, long longitude, LocalTime openTime, LocalTime closeTime, RestaurantManager restaurantManager){
        Restaurant restaurant = restaurantService.addRestaurant(restaurantName,latitude,longitude,openTime,closeTime, restaurantManager);
        return restaurant;
    }

    public void addItemToRestaurant(String restaurantId, String itemName, int price, int timeToCook){
        restaurantService.addItemToRestaurant(restaurantId,itemName,price,timeToCook);
    }

    public void updateRestaurantStatus(String restaurantId, RestaurantStatus restaurantStatus){
        restaurantService.updateRestaurantStatus(restaurantId,restaurantStatus);
    }

    public List<Restaurant> searchByDish(String dishName){
        Map<String,List<Restaurant>> dishToRestaurant  = restaurantService.getDishToRestaurantMap();

        for(Map.Entry<String,List<Restaurant>> entry : dishToRestaurant.entrySet()){
            if(entry.getKey().equals(dishName)){
                return entry.getValue();
            }
        }
        return List.of();
    }

    public List<Restaurant> searchByRestaurantName(String name){
        return restaurantService.getRestaurants().values()
                .stream()
                .filter(restaurant -> restaurant.getRestaurantName().equals(name))
                .collect(Collectors.toList());
    }

    public Restaurant findRestaurantById(String restaurantId){
        return restaurantService.findRestaurantById(restaurantId);
    }

}
