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

public class BonusCard extends Card {
    public static final int Count = 25;
    public static final int Count200 = 5;
    public static final int Count300 = 5;
    public static final int Count400 = 5;
    public static final int Count500 = 5;
    public static final int Count600 = 5;
    public int Bonus;

    public BonusCard(int bonus){
        Bonus = bonus;
    }
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
            System.out.println("Kept combinations: ");
            UI.ShowCombinations(keptCombinations);
            diceCount = setDiceCount(diceCount, combinationsToKeep);

            points += calculatePoints(keptCombinations);

            if(diceCount == 0){ // if TUTTO
                UI.SayThatTutto();
                System.out.println("You received bonus: " + Bonus + "points");
                points += Bonus;
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
        return CardType.BonusCard;
    }
}
