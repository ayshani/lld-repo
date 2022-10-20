package bowlingalley.scoreboard;

import bowlingalley.constant.AppConstant;
import bowlingalley.factory.BonusFactory;
import bowlingalley.model.Bonus;
import lombok.Getter;

@Getter
public class ScoreBoardImpl extends ScoreBoard{

    private final int[] rolls;
    private Integer currentRoll =0;
    public ScoreBoardImpl() {
        this.rolls = new int[AppConstant.MAX_ROLLS];
    }

    @Override
    public void roll(Integer noofPinsDown) {
        if(currentRoll== AppConstant.MAX_ROLLS-1)
            rolls[currentRoll] = noofPinsDown;
        else
            rolls[currentRoll++] = noofPinsDown;
    }

    @Override
    public Integer score() {
        int totalScore =0;
        int set =0;
        for(int i =0; i< AppConstant.TOTAL_SETS;i++){
            if(isStrike(set)){
                totalScore+= AppConstant.TOTAL_PINS + BonusFactory.getStrategy(Bonus.STRIKE).bonus();
            } else if(isSpare(set))
            {
                totalScore+= AppConstant.TOTAL_PINS + BonusFactory.getStrategy(Bonus.SPARE).bonus();
            } else{
                totalScore+= rolls[set] + rolls[set+1];
            }
            set+=2;
        }

        return totalScore + rolls[set];// rolls[set] : 21st chance
    }

    @Override
    public boolean isEligibleForLastBonus() {
        return rolls[currentRoll-1] + rolls[currentRoll-2] == 10;
    }

    @Override
    public boolean isLastRound() {
        return currentRoll == AppConstant.MAX_ROLLS-1;
    }

    private boolean isSpare(int set) {
        return rolls[set] + rolls[set+1] ==10;
    }

    private boolean isStrike(int set) {
        return 10 == rolls[set] ;
    }
}
