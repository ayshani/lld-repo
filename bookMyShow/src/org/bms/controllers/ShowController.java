package org.bms.controllers;

import lombok.AllArgsConstructor;
import org.bms.model.Movie;
import org.bms.model.Screen;
import org.bms.model.Seat;
import org.bms.model.Show;
import org.bms.services.MovieService;
import org.bms.services.SeatAvailabilityService;
import org.bms.services.ShowService;
import org.bms.services.TheatreService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ShowController {

    private final SeatAvailabilityService seatAvailabilityService;
    private final ShowService showService;
    private final TheatreService theatreService;
    private final MovieService movieService;

    public String createShow(String movieId, String screenId, Date startTime, Integer durationInSeconds){
        Screen screen = theatreService.getScreen(screenId);
        Movie movie = movieService.getMovie(movieId);
        return showService.createShow(movie,screen,startTime,durationInSeconds).getId();
    }

    public List<String> getAvailableSeats(String showId){
        Show show = showService.getShow(showId);
        List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getId).collect(Collectors.toList());
    }
}
