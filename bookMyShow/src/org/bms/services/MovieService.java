package org.bms.services;

import lombok.NonNull;
import org.bms.exception.NotFoundException;
import org.bms.model.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {
    private final Map<String, Movie> movies;

    public MovieService(){
        this.movies =  new HashMap<>();
    }

    public Movie createMovie(@NonNull final String movieName){
        String movieId = UUID.randomUUID().toString();
        Movie movie = new Movie(movieId,movieName);
        movies.put(movieId,movie);
        return movie;
    }

    public Movie getMovie(@NonNull String movieId) {
        if(!movies.containsKey(movieId))
            throw new NotFoundException();
        return movies.get(movieId);
    }
}
