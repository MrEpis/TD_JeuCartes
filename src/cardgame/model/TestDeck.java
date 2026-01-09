package cardgame.model;

public class TestDeck extends Deck {
    public TestDeck() {
        addCard(new Card(Rank.ACE, Suit.CLUBS));
        addCard(new Card(Rank.KING, Suit.SPADES));
    }
}
