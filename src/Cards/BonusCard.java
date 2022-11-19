package Cards;

import Abstract.Card;
import Dice.Combinations.Combination;
import Dice.DiceLogic;
import Dice.DiceResponse;
import Dice.Die;
import Dice.Tutto;
import Enums.CardType;
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
    private boolean hasTutto;

    public BonusCard(int bonus){
        Bonus = bonus;
    }
    @Override
    public Integer Handle(Game game, Player player, CardDeck deck) throws Exception {
        ArrayList<Combination> keptCombinations = new ArrayList<>();
        int diceCount = DiceLogic.initialCount;
        boolean turnIsEnded = false;
        hasTutto = false;
        int points = 0;

        while (!turnIsEnded){
            // UI.SayThatThrowing()
            ArrayList<Die> dice = DiceLogic.ThrowDices(diceCount);
            UI.ShowDice(dice);
            DiceResponse response = DiceLogic.getCombinations(dice);
            // UI.ShowCombinations(response.combinations);
            if(response.isNull){
                //UI.SayThatGotNull()
                return 0;
            }

            ArrayList<Combination> combinationsToKeep = player.chooseCombinations(response.combinations);
            keptCombinations.addAll(combinationsToKeep);
            diceCount = setDiceCount(diceCount, combinationsToKeep);

            points = calculatePoints(keptCombinations);

            if(player.askToContinueTurn(points))
                break;

            if(diceCount == 0){ // if TUTTO
                // UI.SayThatTutto()
                points += Bonus;
                if(player.askToContinueTurn(points))
                    break;
                else
                {
                    player.play(deck, game, points);
                    break;
                }

            }
        }
        return points;
    }

    private int calculatePoints(ArrayList<Combination> combinations){
        int points = 0;
        for(Combination comb : combinations){
            points += comb.getPoints();
        }
        return points;
    }

    private int setDiceCount(int initDiceCount, ArrayList<Combination> combinations){
        for(Combination comb : combinations){
            initDiceCount -= comb.getDice().size();
            if(initDiceCount < 0){
                initDiceCount = 0;
                System.out.println("dice count was set to negative number, now it is 0");
            }
        }
        return initDiceCount;
    }

    @Override
    public CardType GetType() {
        return CardType.BonusCard;
    }
}
