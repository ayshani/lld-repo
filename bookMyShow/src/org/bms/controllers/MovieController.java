package org.bms.controllers;

import lombok.AllArgsConstructor;
import org.bms.services.MovieService;

@AllArgsConstructor
public class MovieController {
    final private MovieService movieService;

    public String createMovie(String movieName){
        return movieService.createMovie(movieName).getId();
    }
}
