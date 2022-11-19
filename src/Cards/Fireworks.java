package Cards;

import GameLogic.CardDeck;
import GameLogic.Game;
import GameLogic.Player;

public class Fireworks extends Card {
    public static final int Count = 5;

    @Override
    public Integer Handle(Game game, Player player, CardDeck deck) {
        return null;
    }

    @Override
    public CardType GetType() {
        return CardType.Fireworks;
    }
}
