import DiceLogic.Dice;
import DiceLogic.Dices;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Dices dices = new Dices();
        dices.ThrowDices();
        for (int i=0; i<6;i++){
            System.out.println(dices.ThrowDices().get(i).ThrowedAmount+"");
        }
    }
}

