package GameLogic;



import Abstract.Card;
import Dice.Combinations.Combination;
import Dice.DiceLogic;
import Dice.Tutto;
import UserInterface.Input;
import UserInterface.UI;

import java.util.ArrayList;

public class Player {
    public int Score = 0;
    public String Name;


    private ArrayList<Tutto> tuttos;
    public Player( ){
        Name = Input.GetPlayerName();
    }
    public void play(CardDeck deck, Game game){
        int points = 0;
        diceCount = DiceLogic.initialCount;
        boolean turnEnded = false;
        Card card = deck.takeCard();
        UI.showCard(card);

        points = card.Handle(this);

        Score += points;
        diceCount = 0;
    }

    public boolean isWinning() {
        return Score >= Game.GoalPoints;
    }

    public void addTutto(Tutto tutto){
        tuttos.add(tutto);
    }

    public boolean askToContinueTurn(){
        return Input.AskPlayerToContinueTurn();
    }

    public ArrayList<Combination> chooseCombination(){

    }
}
