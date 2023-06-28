package blackjack.model;

import blackjack.exception.NoMoreCardsException;
import blackjack.util.Card;
import blackjack.util.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        initializeCards();
        shuffleCards();
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    private void initializeCards() {
        for(Suit suit : Suit.values()){
            for(int i=1;i<14;i++){
                Card card = new Card(suit,i);
                cards.add(card);
            }
        }
    }

    public Card removeOneCard(){
        if(cards.isEmpty())
            throw new NoMoreCardsException("No more cards Available!");
        Card card = cards.remove(cards.size()-1);
        return card;
    }
}
