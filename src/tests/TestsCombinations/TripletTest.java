package TestsCombinations;

import main.Dice.Combinations.Triplet;
import main.Dice.DiceLogic;
import main.Dice.DiceResponse;
import main.Dice.Die;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TripletTest {

    @Test
    void Triplet1() throws Exception {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(0,new Die(1));
        dice.add(0,new Die(1));
        dice.add(0,new Die(1));
        dice.add(0,new Die(1));
        dice.add(0,new Die(2));
        dice.add(0,new Die(5));
        ArrayList<Die> testdice = new ArrayList<>();
        testdice.add(0,new Die(1));
        testdice.add(0,new Die(1));
        testdice.add(0,new Die(1));
        testdice.add(0,new Die(4));
        testdice.add(0,new Die(5));
        testdice.add(0,new Die(1));
        DiceResponse response = DiceLogic.getCombinations(dice);
        DiceResponse testresponse =DiceLogic.getCombinations(testdice);
        assertEquals(response.combinations.get(0).getType(),testresponse.combinations.get(0).getType());
    }
    @Test
    void Triplet2() throws Exception {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(0,new Die(2));
        dice.add(0,new Die(2));
        dice.add(0,new Die(2));
        dice.add(0,new Die(1));
        dice.add(0,new Die(2));
        dice.add(0,new Die(5));
        ArrayList<Die> testdice = new ArrayList<>();
        testdice.add(0,new Die(2));
        testdice.add(0,new Die(2));
        testdice.add(0,new Die(2));
        testdice.add(0,new Die(4));
        testdice.add(0,new Die(5));
        testdice.add(0,new Die(1));
        DiceResponse response = DiceLogic.getCombinations(dice);
        DiceResponse testresponse =DiceLogic.getCombinations(testdice);
        assertEquals(response.combinations.get(0).getType(),testresponse.combinations.get(0).getType());
    }
    @Test
    void Triplet4() throws Exception {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(0,new Die(4));
        dice.add(0,new Die(4));
        dice.add(0,new Die(4));
        dice.add(0,new Die(1));
        dice.add(0,new Die(2));
        dice.add(0,new Die(5));
        ArrayList<Die> testdice = new ArrayList<>();
        testdice.add(0,new Die(4));
        testdice.add(0,new Die(4));
        testdice.add(0,new Die(4));
        testdice.add(0,new Die(4));
        testdice.add(0,new Die(5));
        testdice.add(0,new Die(1));
        DiceResponse response = DiceLogic.getCombinations(dice);
        DiceResponse testresponse =DiceLogic.getCombinations(testdice);
        assertEquals(response.combinations.get(0).getType(),testresponse.combinations.get(0).getType());
    }
    @Test
    void Triplet5() throws Exception {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(0,new Die(5));
        dice.add(0,new Die(5));
        dice.add(0,new Die(5));
        dice.add(0,new Die(1));
        dice.add(0,new Die(2));
        dice.add(0,new Die(5));
        ArrayList<Die> testdice = new ArrayList<>();
        testdice.add(0,new Die(5));
        testdice.add(0,new Die(5));
        testdice.add(0,new Die(5));
        testdice.add(0,new Die(4));
        testdice.add(0,new Die(5));
        testdice.add(0,new Die(1));
        DiceResponse response = DiceLogic.getCombinations(dice);
        DiceResponse testresponse =DiceLogic.getCombinations(testdice);
        assertEquals(response.combinations.get(0).getType(),testresponse.combinations.get(0).getType());
    }
    @Test
    void Triplet6() throws Exception {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(0,new Die(6));
        dice.add(0,new Die(6));
        dice.add(0,new Die(6));
        dice.add(0,new Die(1));
        dice.add(0,new Die(2));
        dice.add(0,new Die(5));
        ArrayList<Die> testdice = new ArrayList<>();
        testdice.add(0,new Die(6));
        testdice.add(0,new Die(6));
        testdice.add(0,new Die(6));
        testdice.add(0,new Die(4));
        testdice.add(0,new Die(5));
        testdice.add(0,new Die(1));
        DiceResponse response = DiceLogic.getCombinations(dice);
        DiceResponse testresponse =DiceLogic.getCombinations(testdice);
        assertEquals(response.combinations.get(0).getType(),testresponse.combinations.get(0).getType());
    }
    @Test
    void getType() {
    }

    @Test
    void getDice() {
    }
}