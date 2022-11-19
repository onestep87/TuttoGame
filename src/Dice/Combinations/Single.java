package Dice.Combinations;

import Dice.Die;

import java.util.ArrayList;

public class Single implements Combination{
    private Die die;
    private CombinationType type;
    public Single(Die die) throws Exception {
        if(die == null) throw new Exception("Die is null");
        if(die.Power != 1 || die.Power != 5)
            throw new Exception("Cannot create a Combination, die power should be 1 or 5");
        this.die = die;
        switch (die.Power){
            case 1:
                type = CombinationType.Single1;
                break;
            case 5:
                type = CombinationType.Singel5;
                break;
        }
    }

    @Override
    public int getPoints() {
        switch (die.Power){
            case 1:
                return 100;
            case 5:
                return 50;
        }
        return 0;
    }

    @Override
    public CombinationType getType() {
        return type;
    }

    @Override
    public ArrayList<Die> getDice() {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(die);
        return dice;
    }
}
