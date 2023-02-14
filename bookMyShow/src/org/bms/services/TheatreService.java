package org.bms.services;

import org.bms.exception.NotFoundException;
import org.bms.model.Screen;
import org.bms.model.Seat;
import org.bms.model.Theatre;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TheatreService {

    private final Map<String, Theatre> theatres;
    private final Map<String, Screen> screens;
    private final Map<String, Seat> seats;

    public TheatreService() {
        this.theatres = new HashMap<>();
        this.screens = new HashMap<>();
        this.seats = new HashMap<>();
    }

    public Theatre createTheatre(final String theatreName){
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre =  new Theatre(theatreId,theatreName);
        theatres.put(theatreId,theatre);
        return theatre;
    }

    public Screen createScreenInTheatre(final String screenName, final Theatre theatre){
        String screenId = UUID.randomUUID().toString();
        Screen screen =  new Screen(screenId,screenName,theatre);
        screens.put(screenId,screen);
        theatre.addScreen(screen);
        return screen;
    }

    public Seat createSeatInScreen(final Integer rowNo, final Integer seatNo, final Screen screen){
        String seatId = UUID.randomUUID().toString();
        Seat seat = new Seat(seatId,rowNo,seatNo);
        seats.put(seatId,seat);
        screen.addSeat(seat);
        return seat;
    }

    public Theatre getTheatre(final String theatreId){
        if(!theatres.containsKey(theatreId))
            throw new NotFoundException();
        return theatres.get(theatreId);
    }

    public Screen getScreen(final String screenId){
        if(!screens.containsKey(screenId)){
            throw new NotFoundException();
        }
        return screens.get(screenId);
    }

    public Seat getSetas(final String seatId){
        if(!seats.containsKey(seatId)){
            throw new NotFoundException();
        }
        return seats.get(seatId);
    }
}
