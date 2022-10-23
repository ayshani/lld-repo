package org.cricinfo.model.match;

import lombok.Data;
import org.cricinfo.model.constants.BallType;
import org.cricinfo.model.constants.RunType;
import org.cricinfo.model.person.Player;

import java.util.List;

@Data
public class Ball {
    private int overNumber;
    private BallType ballType;
    private Player bowledBy;
    private Player facedBy;
    private RunType runType;
    private Wicket wicket;
    private Commentary commentary;
    private List<Run> runs;

    public Ball(int overNumber, Player bowledBy, Player facedBy){
        this.overNumber = overNumber;
        this.bowledBy = bowledBy;
        this.facedBy = facedBy;
    }
}
