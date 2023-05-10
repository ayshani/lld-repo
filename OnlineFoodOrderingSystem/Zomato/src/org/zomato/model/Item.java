package org.zomato.model;

import lombok.Getter;
import lombok.Setter;
import org.zomato.util.ItemStatus;

import java.util.UUID;

@Getter
public class Item {
    private String itemId;
    private String itemName;
    private int price;
    @Setter
    private String restaurantId;
    private ItemStatus itemStatus;
    private int timeToCook;


    public Item(String itemName, int price, String restaurantId, int timeToCook) {
        this.itemId = UUID.randomUUID().toString();
        this.itemName = itemName;
        this.price = price;
        this.restaurantId = restaurantId;
        this.timeToCook = timeToCook;
        this.itemStatus = ItemStatus.AVAILABLE;
    }

    public void updateItemStatus(ItemStatus itemStatus){
        this.itemStatus = itemStatus;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", restaurantId='" + restaurantId + '\'' +
                ", itemStatus=" + itemStatus +
                ", timeToCook=" + timeToCook +
                '}';
    }
}
