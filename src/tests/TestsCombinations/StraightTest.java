package TestsCombinations;

import main.Dice.Combinations.Straight;
import main.Dice.DiceLogic;
import main.Dice.DiceResponse;
import main.Dice.Die;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StraightTest {

    @Test
    void tryCombine() throws Exception {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(0,new Die(1));
        dice.add(0,new Die(2));
        dice.add(0,new Die(3));
        dice.add(0,new Die(4));
        dice.add(0,new Die(5));
        dice.add(0,new Die(6));
        ArrayList<Die> testdice = new ArrayList<>();
        testdice.add(0,new Die(3));
        testdice.add(0,new Die(4));
        testdice.add(0,new Die(2));
        testdice.add(0,new Die(2));
        testdice.add(0,new Die(6));
        testdice.add(0,new Die(5));
        Straight straight = new Straight();
        straight.tryCombine(dice);
        assertEquals(straight.tryCombine(dice),false);
        //assertEquals(straight.tryCombine(testdice),false);
    }
}