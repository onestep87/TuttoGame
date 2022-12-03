package Cards;

import Dice.Combinations.Combination;
import Dice.Combinations.Straight;
import Dice.DiceLogic;
import Dice.DiceResponse;
import Dice.Die;
import GameLogic.CardDeck;
import GameLogic.Game;
import GameLogic.Player;
import UserInterface.Input;
import UserInterface.UI;

import java.util.ArrayList;

public class StraightCard extends Card {
    public static final int Count = 5;

    @Override
    public Integer Handle(Game game, Player player, CardDeck deck, int points) throws Exception {
        Straight straightCombination = new Straight();
        int diceCount = DiceLogic.initialCount;
        boolean turnIsEnded = false;

        UI.SayThatThrowing();
        ArrayList<Die> dice = DiceLogic.ThrowDices(diceCount);
        UI.ShowDice(dice);

        straightCombination.dice = DiceLogic.SaveUnique(dice);
        UI.ShowStraightCombination(straightCombination);
        Input.Wait();

        while (!turnIsEnded) {
            UI.SayThatThrowing();
            dice = DiceLogic.ThrowDices(diceCount);
            UI.ShowDice(dice);
            boolean isCombined = straightCombination.tryCombine(dice);
            if(isCombined){
                System.out.println("Some dies where combined to your combination!");
                UI.ShowStraightCombination(straightCombination);
                Input.Wait();
                if(straightCombination.isStraight()){
                    System.out.println("You got STRAIGHT, you receive 2000 points");
                    points += straightCombination.getPoints();
                    // ask if want to continue
                    if(player.askToTakeNewCard(points)){
                        points = player.play(deck, game, points);
                        break;
                    }
                    else
                        break;
                }
            }
            else{
                UI.SayThatGotNull();
                return 0;
            }
        }
        return points;
    }

    @Override
    public CardType GetType() {
        return CardType.StraightCard;
    }
}
