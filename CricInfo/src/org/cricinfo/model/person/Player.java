package org.cricinfo.model.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cricinfo.model.constants.PlayerType;

@Getter
@Setter@ToString
public class Player extends Person {

    private PlayerType playerType;
    private PlayerResponsibility playerResponsibility;
    public Player(String name) {
        super(name);
    }
}
