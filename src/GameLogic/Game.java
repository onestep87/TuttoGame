package GameLogic;

import UI.Input;
import UI.UI;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players=new ArrayList<>();
    protected int PlayerCount;
    protected int GoalPoints;

    boolean GameIsEnded;
    protected int CurrentPlayerIndex=0;

    public Game(int GoalPoints) {
        PlayerCount=Input.GetPlayerNum();
        this.GoalPoints = GoalPoints;
        for (int i =0;i<PlayerCount;i++){
            players.add(new Player());
        }
    }
    public void GameLoop(){
        while (!GameIsEnded){
            if(players.get(CurrentPlayerIndex).isWinning()){
                GameIsEnded = true;
                UI.ShowVictoryScreen(players.get(CurrentPlayerIndex));
                return;
            }
           // Player.
        }
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
