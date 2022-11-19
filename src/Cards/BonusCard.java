package Cards;

import Abstract.Card;
import DiceLogic.DiceLogic;
import DiceLogic.Die;
import GameLogic.Game;
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
    public Integer Handle(Game game, Player player, ArrayList<Die> dies) {
        int points = DiceLogic.CalculatePoints(dies);
        points += 100;
        return points;
    }
}
