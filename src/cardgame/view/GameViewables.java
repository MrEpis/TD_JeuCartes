package cardgame.view;

import cardgame.controller.GameController;

import java.util.ArrayList;

public class GameViewables implements GameViewable {
    public ArrayList<GameViewable> gameViewables;

    public GameViewables() {
        this.gameViewables = new ArrayList<>();
    }

    public void addGameViewable(GameViewable gameViewable) {
        this.gameViewables.add(gameViewable);
    }

    @Override
    public void setController(GameController controller) {
        for (GameViewable gameViewable : gameViewables) {
            gameViewable.setController(controller);
        }
    }

    @Override
    public void promptForPlayerName() {
        for (GameViewable gameViewable : gameViewables) {
            gameViewable.promptForPlayerName();
        }
    }

    @Override
    public void showPlayerName(int playerIndex, String name) {
        for (GameViewable gameViewable : gameViewables) {
            gameViewable.showPlayerName(playerIndex, name);
        }
    }

    @Override
    public void showFaceDownCardForPlayer(int playerIndex, String name) {
        for (GameViewable gameViewable : gameViewables) {
            gameViewable.showFaceDownCardForPlayer(playerIndex, name);
        }
    }

    @Override
    public void promptForFlip() {
        for (GameViewable gameViewable : gameViewables) {
            gameViewable.promptForFlip();
        }
    }

    @Override
    public void showCardForPlayer(int playerIndex, String name, String rank, String suit) {
        for (GameViewable gameViewable : gameViewables) {
            gameViewable.showCardForPlayer(playerIndex, name, rank, suit);
        }
    }

    @Override
    public void showWinner(String winnerName) {
        for (GameViewable gameViewable : gameViewables) {
            gameViewable.showWinner(winnerName);
        }
    }

    @Override
    public void promptForNewGame() {
        for (GameViewable gameViewable : gameViewables) {
            gameViewable.promptForNewGame();
        }
    }
}
