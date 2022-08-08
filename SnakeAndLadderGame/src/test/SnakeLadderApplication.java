package test;

import org.game.Player;
import org.game.SnakeAndLadderGame;

import java.util.Scanner;

/*
https://github.com/gopalbala/snake-and-ladder/blob/master/src/main/java/com/gb/snakeladder/SnakeLadderApplication.java
 */
public class SnakeLadderApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter board size:");
        int boardSize = scanner.nextInt();

        System.out.println("Enter number of Players");
        int numberOfPlayers = scanner.nextInt();

        System.out.println("Enter number of Snakes");
        int numberOfSnakes = scanner.nextInt();

        System.out.println("Enter number of Laders");
        int numberOfLadders = scanner.nextInt();

        SnakeAndLadderGame game = new SnakeAndLadderGame(boardSize,numberOfSnakes,numberOfLadders);
        for(int i=0;i<numberOfPlayers;i++){
            System.out.println("Enter Player name");
            String name  = scanner.next();
            game.addPlayer(name);
        }

        game.startGame();

        System.out.println("Winners ---");
        game.getListOfWinners().stream().forEach(player -> System.out.print(player.getName()+ " "));
    }
}
