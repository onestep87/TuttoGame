package GameLogic;

public class Player {
    private int Score;
    private Game game;
    private String Name;
    public Player(int Score, String Name){
        this.Name=Name;
        this.Score=Score;
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
}
