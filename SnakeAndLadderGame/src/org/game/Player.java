package org.game;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {

    private String name;
    @Setter
    private int currentPosition;
    @Setter
    private boolean won;

    public Player(String name) {
        this.name = name;
        this.currentPosition = 0;
        this.won = false;
    }
}
