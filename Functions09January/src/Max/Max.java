
package Max;

import java.util.Scanner;

/**
 * 1. Calculate Max
 * - Create a method getMax() with two integer (int) parameters, that returns maximal of the two numbers.
 * - Write a program that reads three numbers from the console and prints the biggest of them. Use the getMax()
 *   method you just created.
 *
 * @author Maariana Valentina Mitroi
 */

public class Max {

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
    public static int getMax(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * method  to find the max from three given numbers, using getMax() method
     */
    private static void exerciseOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int second = scanner.nextInt();
        System.out.print("Enter the third number: ");
        int third = scanner.nextInt();

        System.out.print("the biggest from " + first + ", " + second + ", " + third +
                " is: " + getMax(getMax(first, second), third));
    }
}
