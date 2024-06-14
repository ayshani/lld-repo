package util;

import model.Player;

public class Move {

    private Player player;
    private int i;
    private int j;

    public Move(Player player, int i, int j){
        this.player = player;
        this.i = i;
        this.j = j;
    }

    public Player getPlayer(){
        return player;
    }

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }
}
