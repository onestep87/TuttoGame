package UserInterface;

import java.util.Scanner;

public class Input {
    public static String GetPlayerName(){
        Scanner input = new Scanner(System.in);
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
        Scanner input = new Scanner(System.in);
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


}
