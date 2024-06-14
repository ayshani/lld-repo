package test;

import game.TicTacTo;
import model.Player;
import util.Move;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Tic Tac To Game==================");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Size of the Board :");
        String size = br.readLine();
        TicTacTo game = new TicTacTo(Integer.parseInt(size));
        Player currentPlayer = game.getPlayer1();
        while(!game.isGameEnded()){

            boolean isSuccess = false;
            int retry = 2;
            while(!isSuccess && retry-->0){
                System.out.println("Enter ith and jth Position from available positions :" + game.getAvailablePosition());
                String positions = br.readLine();
                String[] pos = positions.split(" ");
                isSuccess = game.makeAMove(new Move(currentPlayer, Integer.parseInt(pos[0]), Integer.parseInt(pos[1])));
            }
            if(!isSuccess){
                System.out.println("Retry limit exceeded. Ending the game.");
                break;
            } else{
                game.printCurrentBoardStatus();
                System.out.println();
                if(currentPlayer == game.getPlayer1()){
                    currentPlayer = game.getPlayer2();
                } else{
                    currentPlayer = game.getPlayer1();
                }
            }
        }
        if(game.isDraw()){
            System.out.println("Game is a Draw....");
        } else {
            System.out.println("The winner of the game is : "+ game.getWinner());
        }
    }
}