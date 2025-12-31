package cardgame.controller;

import cardgame.evaluators.GameEvaluator;
import cardgame.model.*;
import cardgame.view.GameSwing;
import cardgame.view.GameViewable;

import java.util.ArrayList;

public class GameController {

    private enum GameState {
        AddingPlayer,
        CardsDealt,
        WinnerRevealed;
    };

    GameState gameState;
    Deck deck;
    GameViewable view;
    ArrayList<Player> playerList;
    GameViewable gameViewables;
    GameEvaluator gameEvaluator;
    Player winner;

    public GameController(GameEvaluator gameEvaluator) {
        this.deck = new Deck();
        this.view = new GameSwing();
        view.setController(this);
        gameState = GameState.AddingPlayer;
        playerList = new ArrayList<>();
        this.view.createAndShowGUI();
        this.gameEvaluator = gameEvaluator;
    }

    public void addPlayer(String playerName) {
        Player player = new Player(playerName);
        playerList.add(player);
        view.showPlayerName(playerList.indexOf(player), player.getName());
    }

    public void startGame() {
        if (gameState == GameState.AddingPlayer) {
            // TODO: Get player names from view
            gameState = GameState.CardsDealt;
        }
        deck.shuffleDeck();
        for (Player player : playerList) {
            player.addCard(deck.drawCard());
            view.showFaceDownCardForPlayer(playerList.indexOf(player), player.getName());
        }
        // TODO: Get game state from view
    }

    public void flipCards() {
        for (Player player : playerList) {
            Card card = player.getHand().getCards().getFirst();
            card.setFaceUp(true);
            view.showCardForPlayer(playerList.indexOf(player), player.getName(), card.getRank().toString(), card.getSuit().toString());
        }
        winner = gameEvaluator.evaluateWinner(playerList);
        view.showWinner(new StringBuilder(winner.getName()));
        gameState = GameState.WinnerRevealed;
    }

    public void rebuildDeck() {

    }


}
