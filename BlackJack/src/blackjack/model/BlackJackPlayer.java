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
        // player will keep playing until either he beats the dealer or goes over.
        return true;
    }
}
