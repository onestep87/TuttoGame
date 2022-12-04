package TestsDice;

import main.Dice.DiceLogic;
import main.Dice.DiceResponse;
import main.Dice.Die;
import main.GameLogic.Game;
import main.GameLogic.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class DiceLogicTest {

    @Test
    void throwDices() {
        assertEquals(3, DiceLogic.ThrowDices(3).size());
        assertEquals(1, DiceLogic.ThrowDices(1).size());
        assertEquals(6, DiceLogic.ThrowDices(6).size());
    }
    @Test
    void SaveUnique(){
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(0,new Die(3));
        dice.add(0,new Die(4));
        dice.add(0,new Die(3));
        dice.add(0,new Die(2));
        dice.add(0,new Die(1));
        dice.add(0,new Die(6));
        ArrayList<Die> dicetest = new ArrayList<>();
        dicetest = dice;
        assertNotEquals(dice,DiceLogic.SaveUnique(dicetest));

    }
    @Test
    void getCombinations() throws Exception {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(0,new Die(3));
        dice.add(0,new Die(3));
        dice.add(0,new Die(3));
        dice.add(0,new Die(1));
        dice.add(0,new Die(2));
        dice.add(0,new Die(5));
        ArrayList<Die> testdice = new ArrayList<>();
        testdice.add(0,new Die(3));
        testdice.add(0,new Die(3));
        testdice.add(0,new Die(3));
        testdice.add(0,new Die(4));
        testdice.add(0,new Die(5));
        testdice.add(0,new Die(1));
         DiceResponse response = DiceLogic.getCombinations(dice);
         DiceResponse testresponse =DiceLogic.getCombinations(testdice);
        assertEquals(response.combinations.get(0).getType(),testresponse.combinations.get(0).getType());
    }

}