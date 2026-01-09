package cardgame.model;

public class NormalDeck extends Deck{
    public NormalDeck() {
        for (Suit cardSuit : Suit.values()) {
            for (Rank cardRank : Rank.values()) {
                addCard(new Card(cardRank, cardSuit));
            }
        }
    }
}
