package UserInterface;

import Cards.Card;
import Dice.Combinations.Combination;
import Dice.Die;
import GameLogic.Game;
import GameLogic.Player;

import java.util.ArrayList;

public class UI {
    public static void ShowVictoryScreen(Player player){
        String name =player.Name;
        System.out.println(name +" Has won with score of:"+player.Score);
    }
    public static void ShowDice(ArrayList<Die> dice){
        for (int i=0; i<dice.size();i++){
            System.out.print(dice.get(i).Power+" ");
        }
    }
    public static void ShowPlayersInfo(Game game){
        ArrayList<Player> players = game.getPlayers();
        for (int i=0; i<players.size();i++){
            System.out.println(players.get(i).Name+""+players.get(i).Score+"");
        }
    }
    public static void ShowCombinations(ArrayList<Combination> combinations){
        for (int i=0;i<combinations.size();i++){
            System.out.println(combinations.get(i).getType());
        } // TODO show how much points etc.
    }
    public static void SayThatTutto(){
        System.out.println("Congratulations, you have Tutto!");
    }
    public static void SayThatThrowing(){
        System.out.println("throwing dice ...");
    }
    public static void SayThatGotNull(){
        System.out.println("You got null, you lost all your points at this turn...");
    }
    public static void showCard(Card card){
        System.out.println(card.GetType());
    }
}
