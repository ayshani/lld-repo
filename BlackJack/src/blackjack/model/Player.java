package blackjack.model;

import blackjack.util.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private String name;
    private List<Card> cards;
    public abstract boolean canPlay();
    public abstract boolean wantToPlay();

    public Player(String name){
        this.name =name;
        cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPoints(){
        // count the points in two ways and select the best for the player
        int minTotal =0; //// with ACE worth 1 point
        int maxTotal =0; // with ACE worth 11 point
        for(Card card : cards){
            minTotal += card.getActualValue();
            // this would be the count with ACE counting for 11 points
            maxTotal += card.getActualValue()==1? 11: card.getActualValue();
        }
        // return the most favorable outcome. If considering C_ACE is worth 11 points pushes the
        // total count beyond 21, return the count where it is worth 1 instead.
        return maxTotal>21 ? minTotal : maxTotal;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
