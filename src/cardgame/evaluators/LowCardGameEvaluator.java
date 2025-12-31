package cardgame.evaluators;

import cardgame.model.Card;
import cardgame.model.Player;
import cardgame.model.Rank;
import cardgame.model.Suit;

import java.util.List;

public class LowCardGameEvaluator implements GameEvaluator {

    @Override
    public Player evaluateWinner(List<Player> players) {
        Card bestCard = new Card(Rank.TWO, Suit.DIAMONDS);
        Player bestPlayer = new Player("Initial player");
        Card currentCard;
        for (Player player : players) {
            currentCard = player.getHand().getCards().getFirst();
            if (currentCard.getRank().value < bestCard.getRank().value) {
                bestCard = new Card(currentCard.getRank(), currentCard.getSuit());
                bestPlayer = player;
            } else if (currentCard.getRank().value == bestCard.getRank().value) {
                if (currentCard.getSuit().value < bestCard.getSuit().value) {
                    bestCard = new Card(currentCard.getRank(), currentCard.getSuit());
                    bestPlayer = player;
                }
            }
        }
        return bestPlayer;
    }

}
