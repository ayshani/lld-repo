package org.zomato.model;

import lombok.Getter;
import org.zomato.util.UserStatus;
import org.zomato.util.UserType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class User {
    private String userId;
    private String userName;
    private UserType userType;
    private String email;
    private UserStatus userStatus;
    private List<Address> addressList;

    private Cart userCart;

    public User(String userName, UserType userType, String email){
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.userType = userType;
        this.email = email;
        this.userStatus = UserStatus.ACTIVE;
        this.userCart = new Cart(this);
        addressList = new ArrayList<>();
    }

    public void addAddress(Address address){
        addressList.add(address);
    }

    public List<Address> getAddressList(){
        return addressList;
    }

    public void markUserInactive(){
        userStatus = UserStatus.INACTIVE;
    }

    public void markUserBlocked(){
        userStatus = UserStatus.BLOCKED;
    }

    public void markUserActive(){
        userStatus = UserStatus.ACTIVE;
    }

}
