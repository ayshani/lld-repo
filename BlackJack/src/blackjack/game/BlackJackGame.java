package blackjack.game;

import blackjack.model.BlackJackPlayer;
import blackjack.model.Dealer;
import blackjack.model.Deck;
import blackjack.model.Player;
import blackjack.util.Card;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGame {

    private Deck deck;
    private Player dealer, player;
    private List<Move> moveList;
    private Card hiddenCard;

    public BlackJackGame(String playerName){
        deck = new Deck();
        moveList = new ArrayList<>();
        dealer = new Dealer("Steve");
        hiddenCard = null;
        player = new BlackJackPlayer(playerName);
    }

    public void play(){
        // the first dealer card
        hiddenCard = deck.removeOneCard();

        // give a card to each player
        giveANewCard(player);
        giveANewCard(dealer);

        // let the player play as long as he wants and we are not over
        while(player.canPlay() && player.wantToPlay() && !gameEnded()){
            giveANewCard(player);
        }

        // if the player did not get over (and the game ended), let the dealer play
        if(!gameEnded()){
            // first, turn the hidden card
            giveCard(dealer,hiddenCard);
            while(dealer.canPlay() && !gameEnded()){
                giveANewCard(dealer);
            }
        }

        // show who won
        showGameWinner();
    }

    private void showGameWinner() {
        if(player.getTotalPoints()>21){
            System.out.println(player.getName() + " has lost... " + player.getTotalPoints() + " > 21");
        } else if(dealer.getTotalPoints()>21){
            System.out.println(dealer.getName() + " has lost... " + dealer.getTotalPoints() + " > 21");
        } else{
            Player winner = player.getTotalPoints()>dealer.getTotalPoints() ? player : dealer;
            System.out.println(winner.getName() + " wins... " + winner.getTotalPoints());
        }
    }

    private boolean gameEnded() {
        if(player.getTotalPoints()>=21 || dealer.getTotalPoints()>=21)
            return true;
        return false;
    }

    public void giveANewCard(Player blackJackPlayer){
        giveCard(blackJackPlayer, deck.removeOneCard());
    }

    private void giveCard(Player blackJackPlayer, Card card) {
        Move move = new Move(blackJackPlayer,card);
        moveList.add(move);
        blackJackPlayer.addCard(card);
        System.out.println(move.toString()+"  ("+ blackJackPlayer.getTotalPoints() +" )");
    }
}
