package main.Dice.Combinations;

import main.Dice.Die;

import java.util.ArrayList;

public interface Combination {
    int getPoints();
    CombinationType getType();
    ArrayList<Die> getDice();
}
