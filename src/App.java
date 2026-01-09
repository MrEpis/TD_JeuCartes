import cardgame.builder.Game;
import cardgame.builder.NormalHighCardGameBuilder;
import cardgame.controller.GameController;
import cardgame.strategy.HighCardGameEvaluator;
import cardgame.view.GameSwing;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        GameSwing view = new GameSwing();
        view.createAndShowGUI();

        Game game = new NormalHighCardGameBuilder().getGame();

        //CommandLineView view = new CommandLineView();

        GameController gameController = new GameController(game, view);
        gameController.run();
    }}