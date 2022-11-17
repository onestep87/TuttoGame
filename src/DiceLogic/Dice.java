package DiceLogic;

import java.util.Random;

public class Dice {
    public int ThrowedAmount;
    public int Min; //Min value is inclusive
    public int Max=6; //Max is exclusive
    public Dice(){
        ThrowedAmount= Max;
    }
    public int ThrowDice(){
        Random random = new Random();
        ThrowedAmount = random.nextInt(Max);
        return ThrowedAmount;
    }
}
