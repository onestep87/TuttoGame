package Dice;

import Dice.Combinations.Combination;
import Dice.Combinations.Single;

import java.util.ArrayList;

public class DiceLogic {
    public static int initialCount = 6;
    public static ArrayList<Die> ThrowDices(int count){
        ArrayList<Die> dice = new ArrayList<>(count);
        for (int i = 0; i < count; i++){
            dice.add(new Die());
            dice.get(i).ThrowDice();
        }
      return dice;
    }

    public static DiceResponse getCombinations(ArrayList<Die> dice) throws Exception {
        DiceResponse response = new DiceResponse();
        response.combinations = new ArrayList<>();
        response.combinations.add(new Single(new Die(5)));
        response.combinations.add(new Single(new Die(1)));
        response.isTutto = false;
        response.isNull = false;
        return response; // TODO LEV
    }
}
