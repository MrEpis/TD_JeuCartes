package cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Deck {

    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card removeLast() {
        return this.cards.removeLast();
    }

}
