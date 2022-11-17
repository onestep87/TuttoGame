package DiceLogic;

import java.util.ArrayList;

public class Dices {
    private static int Count = 6;
    private ArrayList<Dice> Dices;
    public Dices(){
        this.Dices = new ArrayList<Dice>();
    }
    public ArrayList<Dice> ThrowDices(){
        for (int i=0;i<Count;i++){
            Dices.add(new Dice());
            Dices.get(i).ThrowDice();
        }
      return Dices;
    }
}
