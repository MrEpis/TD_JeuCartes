import cardgame.controller.GameController;
import cardgame.evaluators.HighCardGameEvaluator;
import cardgame.model.Deck;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameController gc = new GameController(new HighCardGameEvaluator());
    }
}