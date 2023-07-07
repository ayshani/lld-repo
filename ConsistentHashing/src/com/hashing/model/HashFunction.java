package com.hashing.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunction {

    private final MessageDigest messageDigest;

    public HashFunction(){
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public long generateHash(String key){
        messageDigest.reset();
        messageDigest.update(key.getBytes());
        byte[] digest = messageDigest.digest();
        long hash = ((long)(digest[3]& 0xFF)<<24) |
                ((long)(digest[2]& 0xFF)<<16) |
                ((long)(digest[1]& 0xFF)<<8) |
                ((long)(digest[0]& 0xFF));
        return hash;
    }
}
