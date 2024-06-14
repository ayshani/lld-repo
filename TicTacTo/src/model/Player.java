package model;

import java.util.UUID;

public class Player {

    private String playerId;
    private String name;
    private int faceValue;  // {Player1 - 1, Player2 - -1}

    public Player(String name, int val){
        playerId = UUID.randomUUID().toString();
        this.name = name;
        this.faceValue = val;
    }

    public String getPlayerId(){
        return playerId;
    }

    public String getPlayerName(){
        return name;
    }

    public int getFaceValue(){
        return faceValue;
    }

    public String toString(){
        return " Player Name : "+ name + " , faceValue : "+ faceValue;
    }
}
