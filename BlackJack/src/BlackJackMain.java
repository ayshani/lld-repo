import blackjack.game.BlackJackGame;

public class BlackJackMain {
    public static void main(String[] args) {
        System.out.println("Welcome to BlackJack Game ---------");
        BlackJackGame game = new BlackJackGame("Ramesh");
        game.play();
    }
}