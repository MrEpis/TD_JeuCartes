package cardgame.controller;

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
    private Player winner;

    public GameController(Deck deck) {
        this.deck = deck;
        this.view = new GameSwing();
        view.setController(this);
        gameState = GameState.AddingPlayer;
        playerList = new ArrayList<>();
        this.view.createAndShowGUI();
    }

    public void addPlayer(String playerName) {
        Player player = new Player(playerName);
        playerList.add(player);
    }

    public void startGame() {
        if (gameState == GameState.AddingPlayer) {
            // TODO: Get player names from view
            gameState = null;
        }
        deck.shuffleDeck();
        for (Player player : playerList) {
            player.addCard(deck.drawCard());
        }
        // TODO: Get game state from view
    }

    public void flipCards() {
        for (Player player : playerList) {
            player.getHand().getCards().getFirst().setFaceUp(true);
        }
    }

    void evaluateWinner() {
        Card bestCard = new Card(Rank.TWO, Suit.DIAMONDS);
        Card currentCard;
        for (Player player : playerList) {
            currentCard = player.getHand().getCards().getFirst();
            if (currentCard.getRank().value > bestCard.getRank().value) {
                bestCard = new Card(currentCard.getRank(), currentCard.getSuit());
            } else if (currentCard.getRank().value == bestCard.getRank().value) {
                if (currentCard.getSuit().value > bestCard.getSuit().value) {
                    bestCard = new Card(currentCard.getRank(), currentCard.getSuit());
                }
            }
        }
        
    }


}
