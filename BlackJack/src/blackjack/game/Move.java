package blackjack.game;

import blackjack.model.Player;
import blackjack.util.Card;

public class Move {

    private Player player;
    private Card card;

    public Move(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }

    public String toString(){
        return "Move : "+ player.getClass().getSimpleName() +" "+ player.getName() + " take card " + card.toString() ;
    }
}
