package main.Cards;

import main.GameLogic.CardDeck;
import main.GameLogic.Game;
import main.GameLogic.Player;
import main.UserInterface.Input;

public class StopCard extends Card {
    public static final int Count = 10;

    @Override
    public Integer Handle(Game game, Player player, CardDeck deck, int points) {
        System.out.println("You skip this turn");
        Input.Wait();
        return 0;
    }

    @Override
    public CardType GetType() {
        return CardType.StopCard;
    }
}
