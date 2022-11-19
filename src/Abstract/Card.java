package Abstract;


import Enums.CardType;
import GameLogic.CardDeck;
import GameLogic.Game;
import GameLogic.Player;

public abstract class Card {
    // game for plus minus card
    public abstract Integer Handle(Game game, Player player, CardDeck deck) throws Exception;
    public abstract CardType GetType();
}
