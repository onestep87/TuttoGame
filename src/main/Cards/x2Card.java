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

public class x2Card extends Card {
    public static final int Count = 5;

    @Override
    public Integer Handle(Game game, Player player, CardDeck deck, int points) throws Exception {
        ArrayList<Combination> keptCombinations = new ArrayList<>();
        int diceCount = DiceLogic.initialCount;
        boolean turnIsEnded = false;

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

            points += calculatePoints(keptCombinations);

            if(diceCount == 0){ // if TUTTO
                UI.SayThatTutto();
                System.out.println("Your points are doubled!");
                points *= 2;
                if(player.askToTakeNewCard(points)){
                    points = player.play(deck, game, points);
                    break;
                }
                else
                    break;
            }
            if(!player.askToContinueTurn(points, game))
                break;

        }
        return points;
    }

    @Override
    public CardType GetType() {
        return CardType.x2Card;
    }
}
