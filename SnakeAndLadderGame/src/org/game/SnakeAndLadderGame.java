package org.game;

import lombok.Getter;

import java.util.*;

@Getter
public class SnakeAndLadderGame {

    private Queue<Player> players;
    private Board board;
    private Dice dice;

    private List<Player> listOfWinners;

    public SnakeAndLadderGame(int boardSize, int numberOfSnakes, int numberOfLadders){
        // Initialize board, dice and playerQueue
        board = new Board(boardSize);
        board.addSnakesAndLadders(numberOfSnakes,numberOfLadders);
        // current value has no meaning though
        dice = new Dice(1,6,2);
        this.players = new ArrayDeque<>();
        this.listOfWinners = new LinkedList<>();
    }

    public void addPlayer(String name){
        this.players.add(new Player(name));
    }

    public void startGame(){

        while(!isGameCompleted()){
            Player player = players.poll();
            int diceRollValue = this.dice.rollDice();

            int newPositionOfPlayer = player.getCurrentPosition() + diceRollValue;

            //If New position is outside board then players position will not be changed
            //Add it in the queue for next turn
            if(newPositionOfPlayer>this.board.getEnd()){
                players.offer(player);
            } else {
                // Players new position is in bound of the board
                player.setCurrentPosition(this.board.getNewPositionAfterGoingThroughSnakesAndLadders(newPositionOfPlayer));
                if(player.getCurrentPosition()== this.board.getEnd()){
                    player.setWon(true);
                    System.out.println("Player " + player.getName() + " has won the Game");
                    this.listOfWinners.add(player);
                } else{
                    System.out.println("Setting Player " + player.getName() + "'s new Position "+ player.getCurrentPosition());
                    players.offer(player); // Back in queue for next turn
                }
            }
        }
    }


    private boolean isGameCompleted() {
        //Game is completed if there is only one player left , basically the looser :)
        return this.players.size()<2;
    }
}
