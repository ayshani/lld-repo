package blackjack.model;

public class BlackJackPlayer extends Player{

    public BlackJackPlayer(String name) {
        super(name);
    }

    @Override
    public boolean canPlay() {
        return this.getTotalPoints()<21;
    }

    @Override
    public boolean wantToPlay() {
        // here is where the player's strategy could be elaborated. The simple strategy
        // is to keep playing as long as the count is lower than 17.
        return this.getTotalPoints()<17;
    }
}
