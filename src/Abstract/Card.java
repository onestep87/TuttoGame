package Abstract;


import DiceLogic.DiceLogic;
import DiceLogic.Die;
import Enums.CardType;
import GameLogic.Game;
import GameLogic.Player;

import java.util.ArrayList;

public abstract class Card {
    // access to points,
    public abstract Integer Handle(Game game, Player player, ArrayList<Die> dies);
    public abstract CardType GetType();
}
