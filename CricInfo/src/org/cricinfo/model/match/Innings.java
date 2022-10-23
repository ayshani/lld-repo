package org.cricinfo.model.match;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Innings {
    private int inningNumber;
    private Map<Integer,Over> overs;

    public Innings(int inningNumber){
        this.inningNumber = inningNumber;
        overs  = new HashMap<>();
    }

    /*
    TO - DO
     */
    public int getinningsScore(){
        return 0;
    }
}
