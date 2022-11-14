package com.stackoverflow.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.UUID;

/*
Photo:
A Photo will have:
an id
path to where the photo is stored
creation time
member who created it.

 */
@Getter
public class Photo {

    private String id;
    private String photoPath;
    private long creationDate;
    private Member creatingMember;

    public Photo(@NonNull Member creatingMember, @NonNull String photoPath){
        this.id = UUID.randomUUID().toString();
        this.creatingMember = creatingMember;
        this.photoPath = photoPath;
        this.creationDate = System.currentTimeMillis();
    }

    public boolean equals(Object that){
        if(that instanceof Photo){
            return this.id.equals(((Photo) that).id);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", creationDate=" + creationDate +
                ", creatingMember=" + creatingMember +
                '}';
    }
}
