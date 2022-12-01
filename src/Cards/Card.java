package Cards;


import Cards.CardType;
import Dice.Combinations.Combination;
import GameLogic.CardDeck;
import GameLogic.Game;
import GameLogic.Player;

import java.util.ArrayList;

public abstract class Card {
    // game for plus minus card
    public abstract Integer Handle(Game game, Player player, CardDeck deck, int points) throws Exception;
    public abstract CardType GetType();

    protected int calculatePoints(ArrayList<Combination> combinations){
        int points = 0;
        for(Combination comb : combinations){
            points += comb.getPoints();
        }
        return points;
    }

    protected int setDiceCount(int initDiceCount, ArrayList<Combination> combinations){
        for(Combination comb : combinations){
            initDiceCount -= comb.getDice().size();
            if(initDiceCount < 0){
                initDiceCount = 0;
                System.out.println("dice count was set to negative number, now it is 0");
            }
        }
        return initDiceCount;
    }
}
