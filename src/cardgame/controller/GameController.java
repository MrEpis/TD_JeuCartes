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
        winner = evaluateWinner();
        view.showWinner(new StringBuilder(winner.getName()));
        gameState = GameState.WinnerRevealed;
    }



    Player evaluateWinner() {
        Card bestCard = new Card(Rank.TWO, Suit.DIAMONDS);
        Player bestPlayer = new Player("Initial player");
        Card currentCard;
        for (Player player : playerList) {
            currentCard = player.getHand().getCards().getFirst();
            if (currentCard.getRank().value > bestCard.getRank().value) {
                bestCard = new Card(currentCard.getRank(), currentCard.getSuit());
                bestPlayer = player;
            } else if (currentCard.getRank().value == bestCard.getRank().value) {
                if (currentCard.getSuit().value > bestCard.getSuit().value) {
                    bestCard = new Card(currentCard.getRank(), currentCard.getSuit());
                    bestPlayer = player;
                }
            }
        }
        return bestPlayer;
    }

    public void rebuildDeck() {

    }


}
