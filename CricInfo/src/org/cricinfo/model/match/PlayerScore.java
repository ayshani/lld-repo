package org.cricinfo.model.match;

import org.cricinfo.model.constants.WicketType;
import org.cricinfo.model.person.Player;

import java.util.List;

public class PlayerScore {
    private String name;
    //private List<Integer> runScored;
    private WicketType wicketType;
    private Player bowler;
    private  int isOut;
    private  int totalBoundaries;
    private  int totalSixes;

    public PlayerScore(String name){
        this.name = name;
    }
}
