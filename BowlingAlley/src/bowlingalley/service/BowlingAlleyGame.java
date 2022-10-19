package bowlingalley.service;

import bowlingalley.constant.AppConstant;
import bowlingalley.model.Player;

import java.util.LinkedList;
import java.util.Queue;

public class BowlingAlleyGame {

    Queue<Player> players;
    Player winPlayer;

    public BowlingAlleyGame(){
        this.players = new LinkedList<Player>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void startGame(){
        int maxScore =0;

        for(int index =0; index < AppConstant.TOTAL_SETS;index++){
            int standingPins = AppConstant.TOTAL_PINS;

            for(Player player : players){
                if(isEligibleForExtraBall(player)){

                }
            }
        }
    }

    private boolean isEligibleForExtraBall(Player player) {

    }
}
