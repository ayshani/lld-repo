package org.bms.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Show {
    private final String id;
    private final Movie movie;
    private final Screen screen;
    private final Date startTime;
    private final Integer durationInSeconds;

    public Show(String id, Movie movie, Screen screen, Date startTime, Integer durationInSeconds) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.durationInSeconds = durationInSeconds;
    }
}
