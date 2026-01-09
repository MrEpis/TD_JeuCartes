package cardgame.controller;

import cardgame.builder.Game;
import cardgame.strategy.GameEvaluator;
import cardgame.model.*;
import cardgame.view.GameSwing;
import cardgame.view.GameViewable;
import cardgame.view.GameViewables;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private enum GameState {
        AddingPlayer,
        CardsDealt,
        WinnerRevealed;
    };

    private final GameViewables views;
    private final GameEvaluator gameEvaluator;
    private final List<Player> players;
    private final Deck deck;

    private GameState gameState;

    public GameController(Game game, GameViewable view) {
        this.deck = game.getDeck();
        this.views = new GameViewables();
        this.views.addGameViewable(view);
        view.setController(this);

        this.gameState = GameState.AddingPlayer;
        this.players = new ArrayList<>();
        this.gameEvaluator = game.getEvaluator();
        run();
    }

    public void run() {
        switch (gameState) {
            case AddingPlayer -> views.promptForPlayerName();
            case CardsDealt -> views.promptForFlip();
            case WinnerRevealed -> views.promptForNewGame();
        }
    }

    public void addPlayer(String playerName) {
        if (gameState != GameState.AddingPlayer || players.size() >= 5) {
            return;
        }

        players.add(new Player(playerName));

        for (int i = 0; i < players.size(); i++) {
            views.showPlayerName(i, players.get(i).getName());
        }

        run();
    }

    public void startGame() {
        deck.shuffle();
        for (int i = 0; i < players.size(); i++) {
            players.get(i).getHand().addCard(deck.removeLast());
            views.showFaceDownCardForPlayer(i, players.get(i).getName());
        }

        gameState = GameState.CardsDealt;
        run();
    }

    public void flipCards() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).getHand().getCards().getFirst().setFaceUp(true);
            Card card = players.get(i).getHand().getCards().getFirst();
            views.showCardForPlayer(i, players.get(i).getName(), card.getRank().name(), card.getSuit().name());
        }

        evaluateWinner();

        rebuildDeck();

        gameState = GameState.WinnerRevealed;
        run();
    }

    public void rebuildDeck() {
        for (Player player : players) {
            Card card = player.getHand().getCards().getFirst();
            deck.addCard(card);
            player.getHand().removeCard(card);
        }
    }

    void evaluateWinner() {
        Player winner = this.gameEvaluator.evaluateWinner(players);
        if (winner != null) {
            displayWinner(winner.getName());
        }
    }

    void displayWinner(String winnerName) {
        views.showWinner(winnerName);
    }

    public void addView(GameViewable view) {
        this.views.addGameViewable(view);
    }

    public boolean checkPlayerCount() {
        return !players.isEmpty();
    }


}
