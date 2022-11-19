package Cards;

import Abstract.Card;
import DiceLogic.Die;
import Enums.CardType;
import GameLogic.Game;
import GameLogic.Player;

import java.util.ArrayList;

public class Cloverleaf extends Card {
    public static final int Count = 1;

    @Override
    public Integer Handle(Game game, Player player, ArrayList<Die> dies) {
        return null;
    }

    @Override
    public CardType GetType() {
        return CardType.Cloverleaf;
    }
}
