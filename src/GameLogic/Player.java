package GameLogic;



import Cards.Card;
import Dice.Combinations.Combination;
import UserInterface.Input;
import UserInterface.UI;

import java.util.ArrayList;

public class Player {
    public int Score = 0;
    public String Name;
    public Player( ){
        Name = Input.GetPlayerName();
    }

    public void play(CardDeck deck, Game game, int points) throws Exception {
        Card card = deck.takeCard();
        UI.showCard(card);

        points = card.Handle(game,this, deck);

        Score += points;
    }

    public boolean isWinning() {
        return Score >= Game.GoalPoints;
    }

    public boolean askToContinueTurn(int points){
        return Input.AskPlayerToContinueTurn(points);
    }

    public ArrayList<Combination> chooseCombinations(ArrayList<Combination> combinations){
        combinations = Input.WhichCombinationsToKeep(combinations);
        return combinations;
    }
}
