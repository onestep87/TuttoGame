package Cards;

import Abstract.Card;
import DiceLogic.Die;
import Enums.CardType;
import GameLogic.Game;
import GameLogic.Player;

import java.util.ArrayList;

public class StopCard extends Card {
    public static final int Count = 10;

    @Override
    public Integer Handle(Game game, Player player, ArrayList<Die> dies) {
        return 0;
    }

    @Override
    public CardType GetType() {
        return CardType.StopCard;
    }
}
