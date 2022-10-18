package bowlingalley.factory;

import bowlingalley.model.Bonus;
import bowlingalley.strategy.DefaultStrategy;
import bowlingalley.strategy.Strategy;

public class BonusFactory {
    public static Strategy getStrategy(Bonus bonus){
        return new DefaultStrategy();
    }
}
