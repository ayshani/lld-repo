package com.splitwise.service;

import com.splitwise.model.User;
import com.splitwise.repository.Group;

public class UserService {

    Group group;

    public UserService(Group group){
        this.group = group;
    }

    public void addUser(User user){
        this.group.addUser(user);
    }

    public User getUser(String userName){
        return this.group.getUser(userName);
    }
}
