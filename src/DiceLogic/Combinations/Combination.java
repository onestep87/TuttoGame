package DiceLogic.Combinations;

import DiceLogic.Die;

import java.util.ArrayList;

public interface Combination {
    int getPoints();
    CombinationType getType();
    ArrayList<Die> getDice();
}
