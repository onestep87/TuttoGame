package UserInterface;

import Abstract.Card;
import DiceLogic.DiceLogic;
import GameLogic.Game;
import GameLogic.Player;

import java.util.ArrayList;

public class UI {
    public static void ShowVictoryScreen(Player player){
        String name =player.GetName();
        int points = player.GetScore();
        System.out.println(name +" Has won with score of:"+points);
    }
    public static void ShowDice(DiceLogic dice){
        for (int i=0; i<6;i++){ //6 dices, maybe change hardcoded value later
            System.out.println(dice.ThrowDices().get(i).Power+"");
        }
    }
    public static void ShowPlayersInfo(Game game){
        ArrayList<Player> players = game.getPlayers();
        for (int i=0; i<players.size();i++){
            System.out.println(players.get(i).GetName()+""+players.get(i).Score+"");
        }
    }
    public static boolean continueTurn(){
        boolean check=false;
        return check;
    }
    public static void showCard(Card card){
        System.out.println(card.GetType());
    }
}
