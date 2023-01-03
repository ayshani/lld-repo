package org.meetingscheduler.model.user;

public abstract class User {

    private String userId;
    private String name;
    private String email;

    public User(String uId,String name, String email) {
        this.userId = uId;
        this.name = name;
        this.email = email;
    }
}
