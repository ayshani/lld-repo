package org.zomato;

import org.zomato.controller.*;
import org.zomato.model.*;
import org.zomato.util.RestaurantStatus;

import java.time.LocalTime;
import java.util.List;

public class Zomato {

   private UserController userController;
   private RestaurantController restaurantController;
   private User admin;
   private UserCartController userCartController;
   private PaymentController paymentController;

   private OrderController orderController;


   public Zomato(){

      restaurantController = new RestaurantController();
      userController = new UserController(restaurantController);
      userCartController  = new UserCartController(restaurantController);
      paymentController = new PaymentController();
      orderController = new OrderController(userController,paymentController);
      initializeApp();
   }

   private void initializeApp() {

      userController.addAdmin("Admin1","admin1@gmail.com");
      userController.addAdmin("Admin2","admin2@gmail.com");
      userController.addAdmin("Admin3","admin3@gmail.com");
   }


   public void registerRestaurant(String restaurantName, long latitude, long longitude, LocalTime openTime, LocalTime closeTime, RestaurantManager restaurantManager){
      restaurantController.addRestaurant(restaurantName,latitude,longitude,openTime,closeTime,restaurantManager);
   }

   public RestaurantManager addRestaurantManager(String userName, String email){
      return userController.addRestaurantManager(userName, email);
   }

   public Customer addCustomer(String userName, String email){
      return userController.addCustomer(userName, email);
   }

   public DeliverBoy addDeliveryBoy(String userName, String email){
      return userController.addDriveryBoy(userName, email);
   }

   public void addItem(RestaurantManager restaurantManager, String itemName, int price, int timeToCook){
      restaurantController.addItemToRestaurant(restaurantManager.getRestaurant().getRestaurantId(),itemName,price,timeToCook);
   }

   public void updateRestaurantStatus(RestaurantManager manager, RestaurantStatus restaurantStatus){
      restaurantController.updateRestaurantStatus(manager.getRestaurant().getRestaurantId(),restaurantStatus);
   }

   public void addAddress(User user, String addressDetails, long latitude, long longitude){
      userController.addAddress(user, new Address(addressDetails,latitude,longitude));
   }

   public List<Restaurant> searchRestaurantByDish(String userId, String dishName){
      return userController.searchByDish(userController.getUser(userId), dishName);
   }

   public List<Item> showItems(String userId, Restaurant restaurant){
      if(restaurant.getItems().size()==0){
         System.out.println("No item is present in "+ restaurant.getRestaurantName());
         return List.of();
      }

      return restaurant.getItems().values().stream().toList();
   }

   public void addToCart(String userId, Item item){
      userCartController.addItemToCart(userController.getUser(userId),item);
   }

   public List<Restaurant> searchRestaurantByName(String userId, String restaurantName){
      return userController.searchByName(userController.getUser(userId), restaurantName);
   }

   public Order placeOrder(String userId){
      Order order =  orderController.placeOrder(userController.getUser(userId));
      if(null == order){
         System.out.println("try again later,  "+ userController.getUser(userId).getUserName());
      }
      return order;
   }

   public void checkOrderStatus(String userId, Order order){
      if(null ==order){
         System.out.println("Hi " +userController.getUser(userId).getUserName() +" , your order is not placed. Please try again later.");
         return;
      }
      orderController.checkStatus(order);
   }

   public void updateDeliveryBoyLocation(String deliveryBoyId, int latitude, int longitude){
      userController.updateLocationOfDeliveryBoy(deliveryBoyId,latitude,longitude);
   }
}
