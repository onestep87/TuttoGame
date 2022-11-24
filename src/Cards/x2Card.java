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

public class x2Card extends Card {
    public static final int Count = 5;

    @Override
    public Integer Handle(Game game, Player player, CardDeck deck) throws Exception {
        ArrayList<Combination> keptCombinations = new ArrayList<>();
        int diceCount = DiceLogic.initialCount;
        boolean turnIsEnded = false;
        int points = 0;

        while (!turnIsEnded){
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
            diceCount = setDiceCount(diceCount, combinationsToKeep);

            points = calculatePoints(keptCombinations);

            if(diceCount == 0){ // if TUTTO
                UI.SayThatTutto();
                points *= 2;
            }
            if(player.askToContinueTurn(points)){
                player.play(deck, game, points);
                break;
            }
            else
                break;

        }
        return points;
    }

    @Override
    public CardType GetType() {
        return CardType.x2Card;
    }
}
