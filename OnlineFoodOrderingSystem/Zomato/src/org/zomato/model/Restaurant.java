package org.zomato.model;

import lombok.Getter;
import org.zomato.util.RestaurantStatus;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class Restaurant {

    private String restaurantId;
    private String restaurantName;
    private long latitude;
    private long longitude;
    private RestaurantStatus restaurantStatus;
    private LocalTime openTime;
    private LocalTime closeTime;

    private Map<String, Item> items;
    private RestaurantManager restaurantManager;


    public Restaurant(String restaurantName, long latitude, long longitude, LocalTime openTime, LocalTime closeTime, RestaurantManager restaurantManager) {
        this.restaurantId = UUID.randomUUID().toString();
        this.restaurantName = restaurantName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.restaurantStatus = RestaurantStatus.CLOSE;
        this.items = new HashMap<>();
        this.restaurantManager =restaurantManager;
    }

    public void updateRestaurantStatus(RestaurantStatus restaurantStatus){
        this.restaurantStatus = restaurantStatus;
    }



    public void addItem(Item item){
        items.putIfAbsent(item.getItemId(), item);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId='" + restaurantId + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", restaurantStatus=" + restaurantStatus +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", items=" + items +
                ", restaurantManager=" + restaurantManager +
                '}';
    }
}
