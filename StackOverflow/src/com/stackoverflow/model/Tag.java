package com.stackoverflow.model;

import lombok.Getter;

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
}
