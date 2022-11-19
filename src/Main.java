import DiceLogic.DiceLogic;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        DiceLogic dice = new DiceLogic();
        dice.ThrowDices();
        for (int i=0; i<6;i++){
            System.out.println(dice.ThrowDices().get(i).Power +"");
        }
        //

    }
}

