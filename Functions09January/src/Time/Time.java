
/**
 * 3. Input Data Validation
 * - write a program that asks the user what time it is, by printing on the console
 *   "What time is it?".Then the user must enter two numbers – one for hours and one for minutes.
 *   If the input data represents a valid time, the program must output the message " The time is hh:mm now.",
 *   where hh respectively means the hours, and mm – the minutes. If the entered hours or minutes are not valid,
 *   the program must print the message " Incorrect time!". The validation must be implemented in a separate method.
 *
 * @author Maariana Valentina Mitroi
 */


package Time;

import java.util.Scanner;

public class Time {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exerciseThree();
    }

    /**
     * method to verify if the user inputs valid hour and minutes
     *
     * @param hour  - the number that will represent the hour
     * @param minutes - the number that will represent the minutes
     *
     * @return true if the hour and minutes are valid, or false otherwise
     */
    public static  boolean verifyTime(int hour, int minutes){
        return  (hour >= 0 &&
                hour <= 23 &&
                minutes >=0 &&
                minutes <=59);
    }

    /**
     * method to read from keyboard values for hour and minutes
     * verify the values using verifyTime() method, and if the time is valid, will be displayed
     */
    private static void exerciseThree(){
        System.out.println("What time is it?");
        System.out.println("hh: ");
        int hour = scanner.nextInt();
        System.out.println("mm: ");
        int minutes = scanner.nextInt();
        if (verifyTime(hour, minutes)){
            if (hour < 10){
                if (minutes < 10){
                    System.out.println("The time is: 0" + hour + ":0" + minutes + " now.");
                }else {
                    System.out.println("The time is: 0" + hour + ":" + minutes + " now.");
                }
            }else {
                if (minutes < 10) {
                    System.out.println("The time is: " + hour + ":0" + minutes + " now.");
                }else {
                    System.out.println("The time is: " + hour + ":" + minutes + " now.");
                }
            }
        }else {
            System.out.print("Incorrect time!");
        }
    }
}
