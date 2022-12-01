package Cards;

import GameLogic.CardDeck;
import GameLogic.Game;
import GameLogic.Player;

public class StopCard extends Card {
    public static final int Count = 10;

    @Override
    public Integer Handle(Game game, Player player, CardDeck deck, int points) {
        return 0;
    }

    @Override
    public CardType GetType() {
        return CardType.StopCard;
    }
}
