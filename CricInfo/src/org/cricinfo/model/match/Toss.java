package org.cricinfo.model.match;

import lombok.Getter;
import lombok.Setter;
import org.cricinfo.model.person.Player;

@Getter
@Setter
public class Toss {

    private Player tossedBy;
    private Player askedBy;
    private Team wonByTeam;
    private TossAction tossAction;

}
