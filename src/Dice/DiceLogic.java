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
      return dice;
    }

    public static DiceResponse getCombinations(ArrayList<Die> dice) throws Exception {
        DiceResponse response = new DiceResponse();
        response.combinations = new ArrayList<>();
        response.isTutto = false;

        int counter = 0;
        for(int b=0;b<=1;b++){
            for(int i=1;i<=6;i++){
                for(int j=0;j<dice.size();j++){
                    if(dice.get(j).Power==i){
                        counter++;
                        if (counter==3){
                            ArrayList<Die> dice1 = new ArrayList<>();
                            dice1.add(new Die(i));
                            dice1.add(new Die(i));
                            dice1.add(new Die(i));
                            response.combinations.add(new Triplet(dice1));
                        }
                        break;
                    }
                }
                if(counter == 3){
                    for (int a=0;a<dice.size();a++){
                        if (dice.get(a).Power == i){
                            counter--;
                            dice.remove(a);
                            if (counter==0){
                                break;
                            }
                        }
                    }
                }
                counter = 0;
            }
        }
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
        if (dice.size()==6){
            response.isNull = true;
        }
        if(dice.size()==0){
            response.isTutto = true;
        }
        return response; // TODO LEV
    }
}
