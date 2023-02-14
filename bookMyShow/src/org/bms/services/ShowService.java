package org.bms.services;

import org.bms.exception.NotFoundException;
import org.bms.exception.ScreenAlreadyOccupiedException;
import org.bms.model.Movie;
import org.bms.model.Screen;
import org.bms.model.Show;

import java.time.DateTimeException;
import java.util.*;

public class ShowService {
    final Map<String, Show> shows;

    public ShowService(){
        this.shows = new HashMap<>();
    }

    public Show createShow(final Movie movie, final Screen screen, final Date startTime, final Integer durationInSeconds){
        if(!checkIfShowCreationAllowed(screen, startTime, durationInSeconds)){
            throw new ScreenAlreadyOccupiedException();
        }
        String showId = UUID.randomUUID().toString();
        final Show show = new Show(showId,movie,screen,startTime,durationInSeconds);
        this.shows.put(showId,show);
        return show;
    }

    public Show getShow(final String showId){
        if(!shows.containsKey(showId))
            throw new NotFoundException();
        return shows.get(showId);
    }

    private List<Show> getShowsForScreen(final Screen screen){
        final List<Show> response = new ArrayList<>();
        for(Show show : shows.values()){
            if(show.getScreen().equals(screen)){
                response.add(show);
            }
        }
        return response;
    }

    private boolean checkIfShowCreationAllowed(Screen screen, Date startTime, Integer durationInSeconds) {
        // TODO: Implement this. This method will return whether the screen is free at a particular time for
        // specific duration. This function will be helpful in checking whether the show can be scheduled in that slot
        // or not.
        return true;
    }
}
