package Dice;

import Dice.Combinations.Combination;

import java.util.ArrayList;

public class Tutto {
    public ArrayList<Combination> combinations;
    public int points = 0;
    public Tutto(ArrayList<Combination> combs) throws Exception {
        if(combinations == null) throw new Exception("Cannot create a Tutto combinations are null");
        combinations = combs;
        for(Combination comb : combinations)
            points += comb.getPoints();
    }
}
