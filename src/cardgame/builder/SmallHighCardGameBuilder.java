package cardgame.builder;

import cardgame.factory.DeckFactory;
import cardgame.factory.DeckType;
import cardgame.factory.EvaluatorFactory;
import cardgame.factory.EvaluatorType;

public class SmallHighCardGameBuilder implements GameBuilder {

    @Override
    public Game getGame() {
        return new Game(
                EvaluatorFactory.makeEvaluator(EvaluatorType.HIGHCARD),
                DeckFactory.makeDeck(DeckType.Small)
        );
    }
}
