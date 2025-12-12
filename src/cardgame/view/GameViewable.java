package cardgame.view;

import cardgame.controller.GameController;

public interface GameViewable {
    void setController(GameController gc);

    // same implementation as our CommandLineView
// just show what the controller is telling us
    void showPlayerName(int playerIndex, String playerName);

    void showCardForPlayer(int playerIndex, String playerName, String cardRank, String cardSuit);

    void showWinner(StringBuilder winnerName);

    void showFaceDownCardForPlayer(int playerIndex, String name);

    void promptForPlayerName();

    void promptForFlip();

    void promptForNewGame();

    void showTieBreak();

    void createAndShowGUI();
}
