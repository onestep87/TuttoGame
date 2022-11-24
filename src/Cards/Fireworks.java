package Cards;

import Dice.Combinations.Combination;
import Dice.DiceLogic;
import Dice.DiceResponse;
import Dice.Die;
import GameLogic.CardDeck;
import GameLogic.Game;
import GameLogic.Player;
import UserInterface.UI;

import java.util.ArrayList;

public class Fireworks extends Card {
    public static final int Count = 5;

    @Override
    public Integer Handle(Game game, Player player, CardDeck deck) throws Exception {
        ArrayList<Combination> keptCombinations = new ArrayList<>();
        int diceCount = DiceLogic.initialCount;
        boolean turnIsEnded = false;
        int points = 0;

        while (!turnIsEnded) {
            UI.SayThatThrowing();
            ArrayList<Die> dice = DiceLogic.ThrowDices(diceCount);
            UI.ShowDice(dice);
            DiceResponse response = DiceLogic.getCombinations(dice);
            UI.ShowCombinations(response.combinations);
            if(response.isNull){
                UI.SayThatGotNull();
                return points;
            }

            // keep all valid singles and triplets
            keptCombinations.addAll(response.combinations);
            diceCount = setDiceCount(diceCount, response.combinations);

            points = calculatePoints(keptCombinations);

            if(diceCount == 0){ // if TUTTO
                UI.SayThatTutto();
                diceCount = DiceLogic.initialCount;
            }
        }
        return points;
    }

    @Override
    public CardType GetType() {
        return CardType.Fireworks;
    }
}
