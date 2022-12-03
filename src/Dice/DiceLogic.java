package Dice;

import Dice.Combinations.Combination;
import Dice.Combinations.Single;
import Dice.Combinations.Triplet;

import java.util.ArrayList;

public class DiceLogic {
    public static int initialCount = 6;
    public static ArrayList<Die> ThrowDices(int count){
        ArrayList<Die> dice = new ArrayList<>(count);
        for (int i = 0; i < count; i++){
            dice.add(new Die());
            dice.get(i).ThrowDice();
        }
        // delete
            dice = new ArrayList<>();
            dice.add(new Die(2));
            dice.add(new Die(2));
            dice.add(new Die(2));
            dice.add(new Die(2));
            dice.add(new Die(2));
            dice.add(new Die(2));
        //
      return dice;
    }

    public static DiceResponse getCombinations(ArrayList<Die> dice) throws Exception {
        DiceResponse response = new DiceResponse();
        response.combinations = new ArrayList<>();
        response.isTutto = false;
        int diceCount = dice.size();

        //int counter = 0;
        for(int b=0;b<=1;b++){// two times because it is possible to have 2 triplets
            for(int powerToCheck=1;powerToCheck<=6;powerToCheck++){
                ArrayList<Die> possibleTriplet = new ArrayList<>();
                for(int j=0;j<dice.size();j++){
                    if(dice.get(j).Power==powerToCheck){
                        possibleTriplet.add(dice.get(j));
                        if (possibleTriplet.size()==3){
                            response.combinations.add(new Triplet(possibleTriplet));
                            for(Die die : possibleTriplet)
                                dice.remove(die);
                            diceCount -= 3;
                        }
                    }
                }
            }
        }
        // check for singles
        for (Die die : dice) {
            switch (die.Power) {
                case 1 -> {
                    response.combinations.add(new Single(new Die(1)));
                }
                case 5 -> {
                    response.combinations.add(new Single(new Die(5)));
                }
            }
        }
        if (response.combinations.size()==0){
            response.isNull = true;
        }
        if(dice.size()==0){
            response.isTutto = true;
        }
        return response;
    }
}
