package bowlingalley.service;

import bowlingalley.constant.AppConstant;
import bowlingalley.model.Player;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

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
        int maxScore = 0;
        while(!players.isEmpty()){
            Player currentPlayer = players.poll();

            int standingPins = AppConstant.TOTAL_PINS;
            int roll =2;
            while(roll-->0){
                int pinDown = takeShot(standingPins);
                currentPlayer.getScoreBoard().roll(pinDown);
                standingPins-=pinDown;
                // standingPins become 0 when we get a strike i.e. 10 on the first roll itself.
                // But we need to roll with 0 to increment the currentRoll value in scoreBoard.
                if(standingPins==0){
                    currentPlayer.getScoreBoard().roll(standingPins);
                    break;
                }
            }
            if(currentPlayer.getScoreBoard().isLastRound()) {
                if (currentPlayer.getScoreBoard().isEligibleForLastBonus()) {
                    standingPins = refillPins();
                    int pinDown = takeShot(standingPins);
                    System.out.println("Player : "+ currentPlayer.getName() +" taking Bonus with pinDown "+ pinDown);
                    currentPlayer.getScoreBoard().roll(pinDown);
                }

                int finalScore = currentPlayer.getScoreBoard().score();
                System.out.println("Player : "+ currentPlayer.getName() +" final Score : "+ finalScore);
                if(finalScore>maxScore){
                    maxScore = finalScore;
                    winPlayer = currentPlayer;
                }
            } else{
                players.offer(currentPlayer);
            }
        }
    }

    private int takeShot(int standingPins) {

        return new Random().nextInt(standingPins +1);
    }

    public int refillPins(){
        return AppConstant.TOTAL_PINS;
    }

    public String getWinner(){
        winPlayer.setWon(true);
        return winPlayer.toString();
    }
}
