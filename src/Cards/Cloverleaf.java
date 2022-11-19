package Cards;

import Abstract.Card;
import Dice.Die;
import Enums.CardType;
import GameLogic.CardDeck;
import GameLogic.Game;
import GameLogic.Player;

import java.util.ArrayList;

public class Cloverleaf extends Card {
    public static final int Count = 1;

    @Override
    public Integer Handle(Game game, Player player, CardDeck deck) {
        return null;
    }

    @Override
    public CardType GetType() {
        return CardType.Cloverleaf;
    }
}
