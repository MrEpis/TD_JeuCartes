package cardgame.evaluators;

import cardgame.model.Player;

import java.util.List;

public interface GameEvaluator {
    Player evaluateWinner(List<Player> players);
}

