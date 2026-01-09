package cardgame.model;

public class SmallDeck extends Deck{
    public SmallDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                if (rank.getRank() >= 6) {
                    addCard(new Card(rank, suit));
                }
            }
        }
    }
}
