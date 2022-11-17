package Cards;

import Abstract.Card;
import DiceLogic.DiceLogic;
import DiceLogic.Die;
import GameLogic.Game;
import GameLogic.Player;

import java.util.ArrayList;

public class BonusCard extends Card {
    @Override
    public Integer Handle(Game game, Player player, ArrayList<Die> dies) {
        int points = DiceLogic.CalculatePoints(dies);
        points += 100;
        return points;
    }
}
