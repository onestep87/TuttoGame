package DiceLogic;

import DiceLogic.Combinations.Combination;

import java.util.ArrayList;

public class DiceLogic {
    public static int initialCount = 6;
    public static ArrayList<Die> ThrowDices(){
        ArrayList<Die> dice = new ArrayList<>();
        for (int i = 0; i< initialCount; i++){
            dice.add(new Die());
            dice.get(i).ThrowDice();
        }
      return dice;
    }

    public static int CalculatePoints(ArrayList<Die> dies){ //not final
        int[]counter= new int[5];
        for (int i=0; i<6;i++) // To Change loop requirments
        {
            for (int j=0; j<6;j++)
            {
                if (dies.get(i).Power == 5) {
                    counter[4]++;

                }
                if (dies.get(i).Power == 1) {
                    counter[0]++;

                }
            }
        }
        return 0;// MAKE SOMETHING
    }

    public static ArrayList<Combination> getCombinations(ArrayList<Die> dice){
        return null; // TO DO
    }

}
