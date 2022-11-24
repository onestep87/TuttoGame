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
        response.combinations = null;
        response.isTutto = false;
        return response; // TODO LEV
    }
}
