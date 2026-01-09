package cardgame.builder;

import cardgame.strategy.GameEvaluator;
import cardgame.model.Deck;

public class Game {
    GameEvaluator ge;
    Deck deck;

    public Game(GameEvaluator ge, Deck deck) {
        this.ge = ge;
        this.deck = deck;
    }
    public GameEvaluator getEvaluator() {return ge;}

    public Deck getDeck() {return deck;}
}
