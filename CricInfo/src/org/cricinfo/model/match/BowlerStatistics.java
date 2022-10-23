package org.cricinfo.model.match;

import lombok.Data;
import org.cricinfo.model.constants.BallType;
import org.cricinfo.model.person.Player;

import java.util.Map;

@Data
public class BowlerStatistics {

    private Player bowler;
    private Map<Integer, Over> overMap;
    private Map<BallType, Integer> extrasBowled;
    private int wicketsTaken;

    public BowlerStatistics(Player bowler){
        this.bowler = bowler;
    }
}
