package Cards;

import Abstract.Card;
import Dice.Combinations.Combination;
import Dice.DiceLogic;
import Dice.Die;
import Enums.CardType;
import GameLogic.Player;

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
    public Integer Handle(Player player) {
        ArrayList<Combination> keptCombinations = new ArrayList<>();
        int diceCount = DiceLogic.initialCount;

        ArrayList<Die> dies = DiceLogic.ThrowDices(diceCount);
        ArrayList<Combination> combinations = DiceLogic.getCombinations(dies);

        // check if tutto and add tutto to array of tutto and throw again
        // ui.showCombinations

        // combTokeep.addRange(input.choose which wo keep)

        for (Combination comb : keptCombinations) {
            diceCount -= comb.getDice().size();
        }
        // check if tutto and add tutto to array of tutto
    }

    @Override
    public CardType GetType() {
        return CardType.BonusCard;
    }
}
