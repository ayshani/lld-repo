package org.bms.controllers;

import lombok.AllArgsConstructor;
import org.bms.model.Screen;
import org.bms.model.Theatre;
import org.bms.services.TheatreService;

@AllArgsConstructor
public class TheatreController {
    final private TheatreService theatreService;

    public String createTheatre(String theatreName){
        return theatreService.createTheatre(theatreName).getId();
    }

    public String createScreenInTheatre(String screenName, String theatreId){
        Theatre theatre =  theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName,theatre).getId();
    }

    public String createSeatInScreen(Integer rowId, Integer seatNo, String screenId){
        Screen screen =  theatreService.getScreen(screenId);
        return theatreService.createSeatInScreen(rowId,seatNo,screen).getId();
    }
}
