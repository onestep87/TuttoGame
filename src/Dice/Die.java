package Dice;

import java.util.Random;

public class Die {
    public int Power;
    public int Min; //Min value is inclusive
    public int Max=7; //Max is exclusive
    public Die(){
        Power = Max;
    }
    public int ThrowDice(){
        Random random = new Random();
        Power = random.nextInt(Max);
        return Power;
    }
    public int getPower(){return Power;}
}
