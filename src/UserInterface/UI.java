package UserInterface;

import Cards.Card;
import Dice.Combinations.Combination;
import Dice.Combinations.Straight;
import Dice.DiceLogic;
import Dice.Die;
import GameLogic.Game;
import GameLogic.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.*;

public class UI {
    public static void ShowVictoryScreen(Player player){
        String name =player.Name;
        System.out.println(name +" Has won with score of:"+player.Score);
    }
    public static void ShowDice(ArrayList<Die> dice){
        for (int i=0; i<dice.size();i++){
            System.out.print(dice.get(i).Power+" ");
        }
        System.out.println();
    }
    public static void ShowPlayersInfo(Game game){
        ArrayList<Player> players = game.getPlayers();
        for (int i=0; i<players.size();i++){
            System.out.println("Name: " + players.get(i).Name+" Points: "+players.get(i).Score);
        }
    }
    public static void SayThatGotNull(){
        System.out.println("You rolled null...");
        Input.Wait();
    }
    public static void ShowCombinations(ArrayList<Combination> combinations){
        for (int i=0;i<combinations.size();i++){
            System.out.print((i + 1) + ". ");
            System.out.print(combinations.get(i).getType());
            System.out.println(" points: " + combinations.get(i).getPoints());
        }
    }
    public static void ShowCombination(Combination combination){
        System.out.println(combination.getType());
    }
    public static void ShowStraightCombination(Straight straight){
        System.out.println("Your straight combination: ");

        ArrayList<Integer> powers = new ArrayList<>();
        for(Die die : straight.getDice())
            powers.add(die.Power);

        Collections.sort(powers);

        for (int i=0;i<straight.getDice().size();i++){
            System.out.print(powers.get(i) + " ");
        }
        System.out.println();
    }
    public static void SayThatTutto(){
        System.out.println("Congratulations, you have Tutto!");
    }
    public static void SayThatThrowing(){
        System.out.println("throwing dice ...");
    }
    public static void showCard(Card card){
        System.out.println(card.GetType());
    }
}
