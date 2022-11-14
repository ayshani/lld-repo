package com.stackoverflow.model;

import lombok.Getter;
import lombok.ToString;

/*
Tag:

A Tag only has a text associated with it.
 */
@Getter
public class Tag {
    private String text;

    public Tag(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "text='" + text + '\'' +
                '}';
    }
}
