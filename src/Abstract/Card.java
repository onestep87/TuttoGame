package Abstract;


import Enums.CardType;
import GameLogic.Player;

public abstract class Card {
    // access to points,
    public abstract Integer Handle(Player player);
    public abstract CardType GetType();
}
