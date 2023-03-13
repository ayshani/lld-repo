package org.decorator;

public class DBService {

    public String getMailFromUsername(String username){
        return username +"@Mail";
    }

    public String getPhoneNumberFromUsername(String username){
        return username + "@Phone";
    }

    public String getFBNameFromUserName(String username){
        return username +"@FaceBook";
    }
}
