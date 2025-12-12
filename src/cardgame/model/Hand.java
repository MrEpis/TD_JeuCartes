package cardgame.model;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
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

    public void removeCard(Card card) {
        if (cards.contains(card)) {
            cards.remove(card);
        } else {
            System.err.println("Card already not in hand.");
        }
    }
}
