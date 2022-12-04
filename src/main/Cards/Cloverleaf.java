package main.Cards;

import main.Dice.Combinations.Combination;
import main.Dice.DiceLogic;
import main.Dice.DiceResponse;
import main.Dice.Die;
import main.GameLogic.CardDeck;
import main.GameLogic.Game;
import main.GameLogic.Player;
import main.UserInterface.UI;

import java.util.ArrayList;

public class Cloverleaf extends Card {
    public static final int Count = 1;

    @Override
    public Integer Handle(Game game, Player player, CardDeck deck, int points) throws Exception {
        ArrayList<Combination> keptCombinations = new ArrayList<>();
        int diceCount = DiceLogic.initialCount;
        boolean turnIsEnded = false;
        int tuttoCount = 0;
        System.out.println("This time you should accomplish tutto twice in a row to win immediately");

        while (!turnIsEnded) {
            UI.SayThatThrowing();
            ArrayList<Die> dice = DiceLogic.ThrowDices(diceCount);
            UI.ShowDice(dice);
            DiceResponse response = DiceLogic.getCombinations(dice);
            UI.ShowCombinations(response.combinations);
            if(response.isNull){
                UI.SayThatGotNull();
                return 0;
            }


            ArrayList<Combination> combinationsToKeep = player.chooseCombinations(response.combinations);
            keptCombinations.addAll(combinationsToKeep);
            System.out.println("Kept combinations: ");
            UI.ShowCombinations(keptCombinations);
            diceCount = setDiceCount(diceCount, combinationsToKeep);

            points = calculatePoints(keptCombinations);

            if(diceCount == 0){ // if TUTTO
                UI.SayThatTutto();
                if(tuttoCount == 0)
                    System.out.println("Now you should accomplish one more tutto");
                tuttoCount++;
                diceCount = DiceLogic.initialCount;
            }
            if(tuttoCount == 2){
                System.out.println("You won using Cloverleaf card!");
                game.forceWin();
                break;
            }
        }
        return 0;
    }

    @Override
    public CardType GetType() {
        return CardType.Cloverleaf;
    }
}
