package main.UserInterface;

import main.Dice.Combinations.Combination;
import main.GameLogic.Game;

import java.util.ArrayList;
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
                if(num < Game.MinPlayerCount || num > Game.MaxPlayerCount)
                    throw new Exception("Invalid player count");
                gotNum=true;
                return num;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
        return num;
    }

    public static Integer GetGoalPoints(){
        System.out.println("Enter goal points:");
        boolean gotNum = false;
        Integer num=0;
        while (!gotNum) {
            try {
                String Input = input.nextLine();
                num = Integer.parseInt(Input);
                if(num < 0)
                    throw new Exception("Invalid goal points");
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
        ArrayList<Combination> combinations_Return = new ArrayList<Combination>();
        while (!gotPlayerChoice) {
            try {
                String Input = input.nextLine();
                String[] numbers = Input.split(" ");
                for (int i=0;i<numbers.length;i++){
                    combinations_Return.add(combinations.get(Integer.parseInt(numbers[i])-1));
                }
                gotPlayerChoice=true;
                return combinations_Return;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
        return null;
    }

    public static Boolean RollOrPlayerInfo(Game game){
        System.out.println("Do you want to continue rolling dices? " +
                "Type R for roll or D to show player info");
        boolean gotPlayerConfirmationTurn = false;
        boolean confirmationForNextTurn= false;
        String name="";
        while (!gotPlayerConfirmationTurn) {
            try {
                name = input.nextLine().toUpperCase();
                if (name.equals("R")){
                    gotPlayerConfirmationTurn=true;
                    return true;
                }
                else if (name.equals("D")){
                    UI.ShowPlayersInfo(game);
                }
                else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Try again, type R for roll or E D to show player info");
            }
        }
        return confirmationForNextTurn;
    }

    public static Boolean AskPlayerToReroll(int points, Game game){
        System.out.println("Do you want to continue rolling dices? " +
                "Type R for roll, E for escape" +
                "\nYour point for this turn:"+points);
        boolean gotPlayerConfirmationTurn = false;
        boolean confirmationForNextTurn= false;
        String name="";
        while (!gotPlayerConfirmationTurn) {
            try {
                name = input.nextLine().toUpperCase();
                if (name.equals("R")){
                    gotPlayerConfirmationTurn=true;
                    return true;
                }
                else if (name.equals("E")){
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

    public static Boolean AskPlayerToTakeNewCard(int points){
        System.out.println("Do you want to take new card? " +
                "Type Y to take or N to end the turn" +
                "\nYour point for this turn:"+points);
        boolean gotPlayerConfirmationTurn = false;
        boolean confirmationForNextTurn= false;
        String name="";
        while (!gotPlayerConfirmationTurn) {
            try {
                name = input.nextLine().toUpperCase();
                if (name.equals("Y")){
                    gotPlayerConfirmationTurn=true;
                    return true;
                }
                else if (name.equals("N")){
                    gotPlayerConfirmationTurn=true;
                    return false;
                }
                else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Try again, type Y to take or N to end the turn");
            }
        }
        return confirmationForNextTurn;
    }

    public static void Wait(){
        input.nextLine();
    }
}
