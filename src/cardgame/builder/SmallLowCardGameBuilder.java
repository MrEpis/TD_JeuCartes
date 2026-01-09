package cardgame.builder;

import cardgame.factory.DeckFactory;
import cardgame.factory.DeckType;
import cardgame.factory.EvaluatorFactory;
import cardgame.factory.EvaluatorType;

public class SmallLowCardGameBuilder implements GameBuilder {
    @Override
    public Game getGame() {
        return new Game(
                EvaluatorFactory.makeEvaluator(EvaluatorType.LOWCARD),
                DeckFactory.makeDeck(DeckType.Small)
        );
    }
}
