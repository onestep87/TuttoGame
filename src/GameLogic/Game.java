package GameLogic;

import UserInterface.Input;
import UserInterface.UI;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players=new ArrayList<>();
    private CardDeck deck;
    protected int PlayerCount;
    public static int GoalPoints;

    boolean GameIsEnded;
    protected Player CurrentPlayer;

    public Game(int GoalPoints) {
        PlayerCount=Input.GetPlayerNum();
        GoalPoints = GoalPoints;
        deck = new CardDeck();

        for (int i =0;i<PlayerCount;i++){
            players.add(new Player());
        }
    }
    public void GameLoop(){
        while (!GameIsEnded){
            nextPlayer();

            if(CurrentPlayer.isWinning()){
                GameIsEnded = true;
                UI.ShowVictoryScreen(CurrentPlayer);
                return;
            }

            CurrentPlayer.play(new CardDeck(), this);


        }
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    private void nextPlayer(){
        if(CurrentPlayer == null)
            CurrentPlayer = players.get(0);

        int curIndex = players.indexOf(CurrentPlayer);
        if(curIndex >= players.size() - 1)
            curIndex = 0;
        else
            curIndex++;
        CurrentPlayer = players.get(curIndex);
    }
}
