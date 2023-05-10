package org.zomato.service;

import lombok.Getter;
import org.zomato.model.Item;
import org.zomato.model.Restaurant;
import org.zomato.model.RestaurantManager;
import org.zomato.util.RestaurantStatus;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class RestaurantService {

    private Map<String, Restaurant> restaurants;
    private Map<String, List<Restaurant>> dishToRestaurantMap;

    public RestaurantService(){
        this.restaurants = new HashMap<>();
        this.dishToRestaurantMap = new HashMap<>();
    }

    public Restaurant addRestaurant(String restaurantName, long latitude, long longitude, LocalTime openTime, LocalTime closeTime, RestaurantManager restaurantManager){
        Restaurant restaurant = new Restaurant(restaurantName,latitude,longitude,openTime,closeTime,restaurantManager);
        restaurantManager.setRestaurant(restaurant);
        restaurants.putIfAbsent(restaurant.getRestaurantId(),restaurant);
        return restaurant;
    }

    public void updateRestaurantStatus(String restaurantId, RestaurantStatus restaurantStatus){
        if(restaurants.containsKey(restaurantId)){
            restaurants.get(restaurantId).updateRestaurantStatus(restaurantStatus);
        }
    }

    public Restaurant findRestaurantById(String restaurantId){
        return restaurants.get(restaurantId);
    }

    public void addItemToRestaurant(String restaurantId, String itemName, int price, int timeToCook){
        if(!restaurants.containsKey(restaurantId))
        {
            System.out.println(" Restaurant doesn't exist");
            return;
        }
        Item item = new Item(itemName,price,restaurantId,timeToCook);
        restaurants.get(restaurantId).addItem(item);
        dishToRestaurantMap.computeIfAbsent(itemName, value -> new ArrayList<Restaurant>());
        dishToRestaurantMap.get(itemName).add(restaurants.get(restaurantId));

    }
}
