
/**
 * 1. Calculate Max
 * - Create a method getMax() with two integer (int) parameters, that returns maximal of the two numbers.
 * - Write a program that reads three numbers from the console and prints the biggest of them. Use the getMax()
 *   method you just created.
 *
 * @author Maariana Valentina Mitroi
 */

import java.util.Scanner;

public class Max {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        exerciseOne();
    }

    /**
     * method to get the max number out of two
     *
     * @param a first number to compare
     * @param b second number to compare
     * @return the biggest number
     */
    public static String getMax(String a, String b) {
        try{
            if (Integer.parseInt(a) >= Integer.parseInt(b)) {
                return a;
            } else {
                return b;
            }
        }catch (NumberFormatException	e) {
            throw new IllegalArgumentException("Arguments should be numbers:	" + e.getMessage());
        }
    }

    /**
     * method  to find the max from three given numbers, using getMax() method
     */
    private static void exerciseOne() {
        System.out.print("Enter the first number: ");
        String first = scanner.nextLine();
        System.out.print("Enter the second number: ");
        String second = scanner.nextLine();
        System.out.print("Enter the third number: ");
        String third = scanner.nextLine();
        try {
            System.out.print("the biggest from " + first + ", " + second + ", " + third +
                    " is: " + getMax(getMax(getMax(first, second), getMax(first, third)), getMax(second, third)));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Invalid	arguments:	" + e.getMessage());
        }
    }
}
