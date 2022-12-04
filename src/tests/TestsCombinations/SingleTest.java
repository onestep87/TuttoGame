package TestsCombinations;

import main.Dice.Combinations.Combination;
import main.Dice.Combinations.Single;
import main.Dice.Die;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SingleTest {

    @Test
    void getPoints() throws Exception {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(0,new Die(5));
        Single single = new Single(dice.get(0));
        single.getPoints();
        int i=50;
        int points = 0;

        assertEquals( i =50,single.getPoints());
    }

    @Test
    void getType() {
    }

    @Test
    void getDice() throws Exception {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(0,new Die(5));
        Single single = new Single(dice.get(0));
        assertEquals(single.getDice(),dice);
    }
}