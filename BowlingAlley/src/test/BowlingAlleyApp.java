package test;

import bowlingalley.model.Player;
import bowlingalley.scoreboard.ScoreBoardImpl;
import bowlingalley.service.BowlingAlleyGame;

// https://github.com/lavakumarThatisetti/Machine-Coding-Round/blob/master/src/com/lavakumar/bowlingalley/Main.java

public class BowlingAlleyApp {
    public static void main(String[] args) {

        Player rahul = new Player("Rahul",new ScoreBoardImpl());
        Player sita = new Player("Sita",new ScoreBoardImpl());

        BowlingAlleyGame game = new BowlingAlleyGame();
        game.addPlayer(rahul);
        game.addPlayer(sita);

        game.startGame();

        System.out.println(game.getWinner());
    }
}