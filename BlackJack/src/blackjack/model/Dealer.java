package blackjack.model;

public class Dealer extends Player{
    public Dealer(String name) {
        super(name);
    }

    @Override
    public boolean canPlay() {
        return this.getTotalPoints()<21;
    }

    @Override
    public boolean wantToPlay() {
        // here is where the dealer's strategy could be elaborated. The simple strategy
        // is to keep playing as long as the count is lower than 17.
        return this.getTotalPoints()<17;
    }
}
