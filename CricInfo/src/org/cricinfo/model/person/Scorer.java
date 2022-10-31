package org.cricinfo.model.person;

import org.cricinfo.model.match.Ball;
import org.cricinfo.model.match.ScoreCard;

public class Scorer extends Person{
    public Scorer(String name) {
        super(name);
    }

    public void setScore(Ball ball, String Match, int innings) {
        //ScoreCard scoreCard = ScoreCard.INSTANCE(Match)
    }
}
