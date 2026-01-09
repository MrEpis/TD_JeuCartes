package cardgame.factory;

import cardgame.model.Deck;
import cardgame.model.NormalDeck;
import cardgame.model.SmallDeck;
import cardgame.model.TestDeck;

public class DeckFactory {

    public static Deck makeDeck(DeckType type) {
        switch (type) {
            case Small -> {
                return new SmallDeck();
            }
            case Normal -> {
                return new NormalDeck();
            }
            case Test -> {
                return new TestDeck();
            }
        }

        return new NormalDeck();
    }
}
