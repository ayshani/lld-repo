package org.cricinfo.model.match;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TournamentsPointsTable {


    Map<Team,Double> teamPoints;
    LocalDateTime updateDate;

    public TournamentsPointsTable(){
        teamPoints = new HashMap<>();
    }
}
