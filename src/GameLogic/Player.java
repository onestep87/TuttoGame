package GameLogic;

import Abstract.Card;
import DiceLogic.Combinations.Combination;
import DiceLogic.DiceLogic;
import DiceLogic.Die;
import UserInterface.Input;

import java.util.ArrayList;

public class Player {
    public int Score = 0;
    private String Name;
    public Player( ){
        Name = Input.GetPlayerName();
    }
    public void play(CardDeck deck, Game game){
        int points=0;
        int diceCount = DiceLogic.initialCount;
        boolean turnEnded = false;
        ArrayList<Combination> keptCombinations = new ArrayList<>();

        while (!turnEnded){
            //ui.showPlayers
            Card card = deck.takeCard();
            // ui.showCard()

            ArrayList<Die> dies = DiceLogic.ThrowDices();
            ArrayList<Combination> combinations = DiceLogic.getCombinations(dies);
            // check if tutto and add tutto to array of tutto and throw again
            // ui.showCombinations
            // combTokeep.addRange(input.choose which wo keep)

            for (Combination comb : keptCombinations) {
                diceCount -= comb.getDice().size();
            }
            // check if tutto and add tutto to array of tutto
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
