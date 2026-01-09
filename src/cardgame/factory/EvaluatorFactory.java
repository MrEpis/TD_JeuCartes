package cardgame.factory;

import cardgame.strategy.GameEvaluator;
import cardgame.strategy.HighCardGameEvaluator;
import cardgame.strategy.LowCardGameEvaluator;

public class EvaluatorFactory {
    public static GameEvaluator makeEvaluator(EvaluatorType type) {
        return switch (type) {
            case HIGHCARD -> new HighCardGameEvaluator();
            case LOWCARD -> new LowCardGameEvaluator();
        };
    }
}
