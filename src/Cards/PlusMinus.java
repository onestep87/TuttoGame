package Cards;

import Dice.Combinations.Combination;
import Dice.DiceLogic;
import Dice.DiceResponse;
import Dice.Die;
import GameLogic.CardDeck;
import GameLogic.Game;
import GameLogic.Player;
import UserInterface.UI;

import java.util.ArrayList;

public class PlusMinus extends Card {
    public static final int Count = 5;

    @Override
    public Integer Handle(Game game, Player player, CardDeck deck, int points) throws Exception {
        ArrayList<Combination> keptCombinations = new ArrayList<>();
        int diceCount = DiceLogic.initialCount;
        boolean turnIsEnded = false;
        points = 0;

        while (!turnIsEnded) {
            UI.SayThatThrowing();
            ArrayList<Die> dice = DiceLogic.ThrowDices(diceCount);
            UI.ShowDice(dice);
            DiceResponse response = DiceLogic.getCombinations(dice);
            UI.ShowCombinations(response.combinations);
            if (response.isNull) {
                UI.SayThatGotNull();
                return 0;
            }

            ArrayList<Combination> combinationsToKeep = player.chooseCombinations(response.combinations);
            keptCombinations.addAll(combinationsToKeep);
            diceCount = setDiceCount(diceCount, combinationsToKeep);

            points += calculatePoints(keptCombinations);

            if(diceCount == 0){ // if TUTTO
                ArrayList<Player> mostSuccessfulPlayers = game.getMostSuccessfulPlayers();

                if (player.Score == mostSuccessfulPlayers.get(0).Score)
                    System.out.println("You are most successful player! You score 1000 points!");
                else{
                    System.out.println("Every player with the most number of points has 1000 points deducted!");
                    for(Player pl : mostSuccessfulPlayers)
                        pl.Score -= 1000;
                }
                points += 1000;
                if(player.askToTakeNewCard(points)){
                    points = player.play(deck, game, points);
                    break;
                }
                else
                    break;
            }
            if(!player.askToContinueTurn(points))
                break;
        }
        return points;
    }

    @Override
    public CardType GetType() {
        return CardType.PlusMinus;
    }
}
