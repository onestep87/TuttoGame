package Cards;

import Abstract.Card;
import DiceLogic.Die;
import Enums.CardType;
import GameLogic.Game;
import GameLogic.Player;

import java.util.ArrayList;

public class StraightCard extends Card {
    public static final int Count = 5;

    @Override
    public Integer Handle(Game game, Player player, ArrayList<Die> dies) {
        return null;
    }

    @Override
    public CardType GetType() {
        return CardType.StraightCard;
    }
}
