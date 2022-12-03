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

    public boolean tryCombine(ArrayList<Die> thrownDice) throws Exception {
        //  check if you can combine
        if(thrownDice == null)
            throw new Exception("Dice is null");
        for (int i = 0; i < thrownDice.size(); i++){
            for (int j = 0; j < dice.size(); j++){
                if (thrownDice.get(i).equals(dice.get(j))){
                    dice.set(j,thrownDice.get(i));
                }
            }
        }
        return false;
    }

    public boolean isStraight(){
        return dice.size() == 6;
    }
}
