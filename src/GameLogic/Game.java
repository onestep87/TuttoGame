package GameLogic;

import UserInterface.Input;
import UserInterface.UI;
import java.util.ArrayList;

public class Game {
    public ArrayList<Player> players=new ArrayList<>();
    private CardDeck deck;
    protected int PlayerCount;
    public static int GoalPoints;
    public static int MinPlayerCount = 2;
    public static int MaxPlayerCount = 10;
    boolean GameIsEnded;
    boolean cloverLeafHandled;
    //protected Player CurrentPlayer;

    public Game(int GoalPoints) {
        PlayerCount=Input.GetPlayerNum();
        this.GoalPoints = GoalPoints;
        deck = new CardDeck();

        for (int i =0;i<PlayerCount;i++){
            players.add(new Player());
        }
    }
    public void GameLoop() throws Exception {
        while (!GameIsEnded){
            for(Player pl : players){
                UI.ShowPlayersInfo(this);
                System.out.println("Player's " + pl.Name + " turn");
                pl.Score += pl.play(deck, this, 0);
                if(cloverLeafHandled){
                    UI.ShowVictoryScreen(pl);
                    GameIsEnded = true;
                    break;
                }
            }

            Player mostSuccsessfulPl = getMostSuccessfulPlayers().get(0);
            if(mostSuccsessfulPl.Score > GoalPoints){
                UI.ShowVictoryScreen(mostSuccsessfulPl);
                break;
            }
        }
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

//    private void nextPlayer(){
//        if(CurrentPlayer == null)
//            CurrentPlayer = players.get(0);
//
//        int curIndex = players.indexOf(CurrentPlayer);
//        if(curIndex >= players.size() - 1)
//            curIndex = 0;
//        else
//            curIndex++;
//        CurrentPlayer = players.get(curIndex);
//    }

    public ArrayList<Player> getMostSuccessfulPlayers(){
        int maxScore = -1;
        Player successfullPlayer = players.get(0);
        ArrayList<Player> mostSuccessfulPlayers = new ArrayList<>();
        for(Player pl : players){
            if(pl.Score > maxScore){
                maxScore = pl.Score;
                successfullPlayer = pl;
            }
        }
        // check if few have highest score
        for(Player pl : players){
            if(pl.Score == successfullPlayer.Score)
                mostSuccessfulPlayers.add(pl);
        }
        return mostSuccessfulPlayers;
    }
}
