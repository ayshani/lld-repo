package org.cricinfo.model.match;

import org.cricinfo.model.constants.RunType;

import java.util.ArrayList;
import java.util.List;

public class Over {
    private int number;
    private int runScored;
    private int extras;
    private int totalRunsInOver;

    private List<Ball> balls;
    private List<Run> runs;

    public Over(int number){
        this.number =number;
        runScored =0;
        extras =0;
        totalRunsInOver = 0;
        balls = new ArrayList<>();
        runs = new ArrayList<>();
    }

    public  boolean isMaidenOver(){
        if(balls.size()>6)
            return false;
        for(Ball ball : balls){
            if(ball.getRunType() != RunType.ZERO)
                return false;
        }
        return true;
    }

    public  int getWicketInOver(){
        int wicketCount =0;
        for(Ball ball: balls){
            if(ball.getWicket() !=null)
                wicketCount++;
        }

        return wicketCount;
    }

}
