package cardgame.view;

import cardgame.controller.GameController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineView implements GameViewable {
    private GameController controller;

    @Override
    public void setController(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void promptForPlayerName() {
        if (controller.checkPlayerCount()) {
            String deal;
            try {
                do {
                    System.out.print("Deal cards ? (y/n) ");
                    deal = new BufferedReader(new InputStreamReader(System.in)).readLine();
                } while (!deal.equalsIgnoreCase("y") && !deal.equalsIgnoreCase("n"));

                if (deal.equalsIgnoreCase("y")) {
                    System.out.println("Cards dealt:");
                    controller.startGame();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.print("Enter Player Name: ");

        try {
            String playerName = new BufferedReader(new InputStreamReader(System.in)).readLine();

            System.out.println("Current players:");
            controller.addPlayer(playerName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showPlayerName(int playerIndex, String name) {
        System.out.println("[" + playerIndex + "][" + name + "]");
    }

    @Override
    public void showFaceDownCardForPlayer(int playerIndex, String name) {
        System.out.println("[" + name + "][][]");
    }

    @Override
    public void promptForFlip() {
        System.out.print("Press enter to reveal cards");

        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();

            System.out.println("Show your cards:");
            controller.flipCards();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showCardForPlayer(int playerIndex, String name, String rank, String suit) {
        System.out.println("[" + name + "][" + rank + ":" + suit + "]");
    }

    @Override
    public void showWinner(String winnerName) {
        System.out.println("Winner!\n" + winnerName);
    }

    @Override
    public void promptForNewGame() {
        System.out.print("Press enter to deal again");

        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();

            System.out.println("Cards dealt:");
            controller.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
