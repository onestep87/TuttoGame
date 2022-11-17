package GameLogic;

import UI.Input;

public class Player {
    private int Score =0;
    private Game game;
    private String Name;
    public Player( ){
        Name = Input.GetPlayerName();

    }
    public int play(){
        int points=0;

        return points;
    }

    public boolean isWinning() {
        if (Score >= game.GoalPoints ) {
            return true;
        }
        else {
            return false;
        }
    }
    public String GetName() {
        return Name;
    }
    public Integer GetScore(){return Score;}
}
