package game;

import model.Board;
import model.Player;
import util.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TicTacTo {

    private Board board;
    private int[] row, col;
    private int diagonal, revereDiagonal;
    private Player player1, player2, winner;

    private List<Move> moves;
    public TicTacTo(final int boardSize){
        board =  new Board(boardSize);
        row = new int[boardSize];
        col = new int[boardSize];
        moves = new ArrayList<>();
        player1 = new Player("A", 1);
        player2 = new Player("B", -1);
        winner = null;
    }

    public boolean makeAMove(Move move){

        if(isValidMove(move)){
            moves.add(move);
            // perform the move
            board.setValue(move.getI(), move.getJ(), move.getPlayer().getFaceValue());
            row[move.getI()] += move.getPlayer().getFaceValue();
            col[move.getJ()] += move.getPlayer().getFaceValue();
            // diagonal count
            if(move.getI() == move.getJ()){
                diagonal += move.getPlayer().getFaceValue();
            }
            // reverse diagonal count
            if(move.getI() == board.getSize() -1 - move.getJ()){
                revereDiagonal += move.getPlayer().getFaceValue();
            }
            if(isWon(move)){
                winner = move.getPlayer();
            }
            return true;
        } else{
            return false;
        }

    }

    public boolean isGameEnded(){
        return getAvailablePosition().size()==0 || null != winner;
    }

    private boolean isWon(Move move){
        if(row[move.getI()] == board.getSize() || col[move.getJ()] == board.getSize() ||  diagonal == board.getSize()
        || revereDiagonal == board.getSize()){
            return true;
        }
        return false;
    }

    private boolean isValidMove(Move move){
        // out of bound check
        if(move.getI()>=board.getSize() || move.getI()<0 || move.getJ()>= board.getSize() || move.getJ()<0){
            return false;
        }
        if(board.getValueFromBoard(move.getI(), move.getJ()) !=0){
            // already occupied
            return false;
        }
        return true;
    }

    public Player getWinner(){
        return winner;
    }

    public Player getPlayer1(){
        return player1;
    }
    public Player getPlayer2(){
        return player2;
    }

    public Map<String,Integer> getAvailablePosition(){
        return board.getAvailablePosition();
    }

    public void printCurrentBoardStatus(){
        board.printBoard();
    }

    public boolean isDraw(){
        return winner== null;
    }
}
