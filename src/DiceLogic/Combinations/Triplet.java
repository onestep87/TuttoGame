package DiceLogic.Combinations;

import DiceLogic.Die;

import java.util.ArrayList;

public class Triplet implements Combination{
    private ArrayList<Die> dice;
    private CombinationType type;
    private int power;
    private int points;
    public Triplet(ArrayList<Die> dice) throws Exception {
        if(isValidDice(dice))
            throw new Exception("Cannot create triplet Combination");
        this.dice = dice;
        power = dice.get(0).Power;
        switch (power){
            case 1:
                type = CombinationType.Triplet1;
                points = 1000;
                break;
            case 2:
                type = CombinationType.Triplet2;
                points = 200;
                break;
            case 3:
                type = CombinationType.Triplet3;
                points = 300;
                break;
            case 4:
                type = CombinationType.Triplet4;
                points = 400;
                break;
            case 5:
                type = CombinationType.Triplet5;
                points = 500;
                break;
            case 6:
                type = CombinationType.Triplet6;
                points = 600;
                break;
            default:
                throw new Exception("Power of triplet is no valid!");
        }

    }
    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public CombinationType getType() {
        return null;
    }

    @Override
    public ArrayList<Die> getDice() {
        return null;
    }

    private boolean isValidDice(ArrayList<Die> dice) throws Exception {
        if(dice == null)
            throw new Exception("Dice is null");
        if(dice.size() != 3)
            return false;

        int dicePower = dice.get(0).Power;
        for(Die tempDie : dice){
            if(tempDie.Power != dicePower)
                return false;
        }
        return true;
    }
}
