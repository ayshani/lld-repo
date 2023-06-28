package blackjack.util;

public class Card {
    private Suit suit;
    private int point;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.point = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getActualValue(){
        if(this.point>10)
            return 10;
        return this.point;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", point=" + getActualValue() +
                '}';
    }
}
