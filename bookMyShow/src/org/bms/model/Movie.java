package org.bms.model;

import lombok.Getter;

@Getter
public class Movie {
    private final String id;
    private final String name;

    public Movie(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
