package main.GameLogic;

import main.UserInterface.Input;
import main.UserInterface.UI;
import java.util.ArrayList;

public class Game {
    public ArrayList<Player> players=new ArrayList<>();
    public CardDeck deck;
    public int PlayerCount;
    public static int GoalPoints;
    public static int MinPlayerCount = 2;
    public static int MaxPlayerCount = 10;
    public boolean GameIsEnded;
    boolean forceWin;

    public Game(int GoalPoints) {
        PlayerCount=Input.GetPlayerNum();
        this.GoalPoints = GoalPoints;
        deck = new CardDeck();

        for (int i =0;i<PlayerCount;i++){
            players.add(new Player());
        }
    }
    public Game(int GoalPoints, int PlayerCount) { //For unit testing
        this.GoalPoints = GoalPoints;
        deck = new CardDeck();
    }
    public void GameLoop() throws Exception {
        while (!GameIsEnded){
            for(Player pl : players){
                UI.ShowPlayersInfo(this);
                System.out.println("===== " + pl.Name + " turn =====");
                Input.Wait();
                pl.Score += pl.play(deck, this, 0);
                if(forceWin){
                    UI.ShowVictoryScreen(pl);
                    GameIsEnded = true;
                    break;
                }
            }

            if(GameIsEnded)
                break;

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

    public void forceWin(){
        forceWin = true;
    }
}
