package main.Dice.Combinations;

import main.Dice.Die;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Straight implements Combination{
    public ArrayList<Die> dice;
    public Straight(){
        this.dice = new ArrayList<>();
    }
    @Override
    public int getPoints() {
        if(dice.size() == 6)
            return 2000;
        else
            return 0;
    }

    @Override
    public CombinationType getType() {
        return CombinationType.Straight;
    }

    @Override
    public ArrayList<Die> getDice() {
        return dice;
    }

    public boolean tryCombine(ArrayList<Die> thrownDice) throws Exception {
        if(thrownDice == null)
            throw new Exception("main.Dice is null");

        Set<Integer> thrownDicePowers = new HashSet<>();
        for(Die die : thrownDice)
            thrownDicePowers.add(die.Power);

        Set<Integer> missingNums = getMissingNumbers();

        // check if can combine
        ArrayList<Die> diceToAdd = new ArrayList<>();
        for(int power : thrownDicePowers){
            if(missingNums.contains(power))
                diceToAdd.add(new Die(power));
        }

        if(diceToAdd.size() == 0)
            return false;

        // combine
        dice.addAll(diceToAdd);

        return true;
    }

    private Set<Integer> getMissingNumbers(){
        // get which numbers are missing
        Set<Integer> dicePowers = new HashSet<>();
        for(Die die : dice)
            dicePowers.add(die.Power);
        Set<Integer> missingPowers = new HashSet<>();
        for(int power : dicePowers){
            if(!dicePowers.contains(power + 1))
                missingPowers.add(power + 1);
            if(!dicePowers.contains(power - 1))
                missingPowers.add(power - 1);
        }

        return missingPowers;
    }

    public boolean isStraight(){
        return dice.size() == 6;
    }
}
