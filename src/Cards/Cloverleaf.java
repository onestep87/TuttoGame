package Cards;

import GameLogic.CardDeck;
import GameLogic.Game;
import GameLogic.Player;

public class Cloverleaf extends Card {
    public static final int Count = 1;

    @Override
    public Integer Handle(Game game, Player player, CardDeck deck, int points) {
        return null;
    }

    @Override
    public CardType GetType() {
        return CardType.Cloverleaf;
    }
}
