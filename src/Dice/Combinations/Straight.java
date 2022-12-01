package Dice.Combinations;

import Dice.Die;

import java.util.ArrayList;

public class Straight implements Combination{
    private ArrayList<Die> dice;
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

    public boolean tryCombine(ArrayList<Die> thrownDice){
        //  check if you can combine
        return false;
    }

    public boolean isStraight(){
        return dice.size() == 6;
    }
}
