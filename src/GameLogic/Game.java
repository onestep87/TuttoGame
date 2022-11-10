package GameLogic;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players=new ArrayList<>();

   protected int GoalPoints;

    public Game(int GoalPoints) {
        this.GoalPoints = GoalPoints;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
