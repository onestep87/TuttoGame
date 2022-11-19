package GameLogic;

import Abstract.Card;
import DiceLogic.DiceLogic;
import DiceLogic.Die;
import UI.Input;

import java.util.ArrayList;

public class Player {
    public int Score = 0;
    private String Name;
    public Player( ){
        Name = Input.GetPlayerName();
    }
    public void play(CardDeck deck, Game game){
        int points=0;
        boolean turnEnded = false;

        while (!turnEnded){
            //ui.showPlayers
            Card card = deck.takeCard();
            // ui.showCard()

            ArrayList<Die> dies = DiceLogic.ThrowDices();

            points += card.Handle(game, this, dies);

        // ask if want to repeat
        }

        Score += points;
    }

    public boolean isWinning() {
        if (Score >= Game.GoalPoints ) {
            return true;
        }
        else {
            return false;
        }
    }
    public String GetName() {
        return Name;
    }
    public Integer GetScore(){return Score;}
}
