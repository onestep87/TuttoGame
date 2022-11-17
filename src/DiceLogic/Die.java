package DiceLogic;

import java.util.Random;

public class Die {
    public int ThrowedAmount;
    public int Min; //Min value is inclusive
    public int Max=7; //Max is exclusive
    public Die(){
        ThrowedAmount= Max;
    }
    public int ThrowDice(){
        Random random = new Random();
        ThrowedAmount = random.nextInt(Max);
        return ThrowedAmount;
    }
    public int getThrowedAmount(){return ThrowedAmount;}
}
