package Dice;

import java.util.Random;

public class Die {
    public int Power;
     //Max is exclusive
    public Die(){
        Power = 6;
    }
    public int ThrowDice(){
        int Max=7;
        Random random = new Random();
        Power = random.nextInt(6) + 1;
        return Power;
    }
    public int getPower(){return Power;}
}
