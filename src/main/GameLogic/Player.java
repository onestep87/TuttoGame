package main.GameLogic;



import main.Cards.Card;
import main.Dice.Combinations.Combination;
import main.UserInterface.Input;
import main.UserInterface.UI;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Player {
    public int Score = 0;
    public String Name;
    public Player(){
        Name = Input.GetPlayerName();
    }
    public Player(String Name){ //for unit testing
        Name= "test";
    }
    public int play(CardDeck deck, Game game, int points) throws Exception {
        Card card = deck.takeCard();
        Input.RollOrPlayerInfo(game);
        UI.showCard(card);


        points = card.Handle(game,this, deck, points);

        Score += points;

        return points;
    }

    public boolean isWinning() {
        return Score >= Game.GoalPoints;
    }

    public boolean askToContinueTurn(int points, Game game){
        return Input.AskPlayerToReroll(points, game);
    }

    public boolean askToTakeNewCard(int points){
        return Input.AskPlayerToTakeNewCard(points);
    }

    public ArrayList<Combination> chooseCombinations(ArrayList<Combination> combinations){
        combinations = Input.WhichCombinationsToKeep(combinations);
        return combinations;
    }
}
