package UserInterface;

import Dice.Combinations.Combination;
import Dice.Combinations.CombinationType;
import Dice.Combinations.Single;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Input {
    public static Scanner input = new Scanner(System.in);
    public static String GetPlayerName(){

        boolean gotName = false;
        System.out.println("Enter player name:");
        String name="";
        while (!gotName) {
            try {
                name = input.nextLine();
                gotName=true;
                return name;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
        return name;
    }
    public static Integer GetPlayerNum(){
        boolean gotNum = false;
        System.out.println("Enter number of players:");
        Integer num=0;
        while (!gotNum) {
            try {
                String Input = input.nextLine();
                num = Integer.parseInt(Input);
                gotNum=true;
                return num;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
        return num;
    }
    public static ArrayList<Combination> WhichCombinationsToKeep(ArrayList<Combination> combinations){
        boolean gotPlayerChoice = false;
        System.out.println("Choose which combination to keep:");
        UI.ShowCombinations(combinations);
        ArrayList<Combination> combinations_Return = new ArrayList<Combination>();
        Integer[] num = new Integer[]{};
        while (!gotPlayerChoice) {
            try {
                String Input = input.nextLine();
                String[] numbers = Input.split(" ");
                for (int i=0;i>numbers.length;i++){
                    num[i]= Integer.parseInt(numbers[i]);
                    combinations_Return.add(num[i-1],combinations.get(i-1));
                }
                gotPlayerChoice=true;
                return combinations_Return;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
        return null;  // TODO
    }

    public static Boolean AskPlayerToContinueTurn(int points){
        System.out.println("Do you want to continue rolling dices? " +
                "Type R for roll or E for escape" +
                "\nYour point for this turn:"+points);
        boolean gotPlayerConfirmationTurn = false;
        boolean confirmationForNextTurn= false;
        String name="";
        while (!gotPlayerConfirmationTurn) {
            try {
                name = input.nextLine();
                if (name=="R"){
                    gotPlayerConfirmationTurn=true;
                    return true;
                }
                else if (name=="E"){
                    gotPlayerConfirmationTurn=true;
                    return false;
                }
                else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Try again, type R for roll or E for ending turn");
            }
        }
        return confirmationForNextTurn;
    }

}
