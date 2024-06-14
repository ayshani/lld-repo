package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private int[][] board;
    private Map<String,Integer> availablePositions;

    public Board(final int n){
        board =  new int[n][n];
        availablePositions = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                availablePositions.put(i+"_"+j,0);
            }
        }
    }

    public int[][] printBoard(){
        Arrays.stream(board).forEach(e-> System.out.println(Arrays.toString(e)));
        return board;
    }

    public int getSize(){
        return board.length;
    }
    public int getValueFromBoard(int i, int j){
        return board[i][j];
    }

    public void setValue(int i, int j, int faceValue) {
        board[i][j] = faceValue;
        availablePositions.remove(i+"_"+j);
    }

    public Map<String,Integer> getAvailablePosition(){
        return availablePositions;
    }

}
