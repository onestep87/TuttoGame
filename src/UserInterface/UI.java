package UserInterface;

import GameLogic.Player;

public class UI {
    public static void ShowVictoryScreen(Player player){
        String name =player.GetName();
        int points = player.GetScore();
        System.out.println(name +" Has won with score of:"+points);
    }
}
