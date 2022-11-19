package UserInterface;

import Dice.Combinations.Combination;

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
        System.out.println("Enter number of players:");
        Integer num=0;
        while (!gotPlayerChoice) {
            try {
                String Input = input.nextLine();
                num = Integer.parseInt(Input);
                gotPlayerChoice=true;
                return null;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
        return null;  // TODO
    }

    public static boolean AskPlayerToContinueTurn(){
        return false; // TODO
    }

}
