package cardgame.model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (int i=1; i<=4; i++) {
            for (int j = 2; j <= 14; j++) {
                Suit suit = Suit.getSuitFromValue(i);
                Rank rank = Rank.getRankFromValue(j);
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.removeFirst();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }


}
