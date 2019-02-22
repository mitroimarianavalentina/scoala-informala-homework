
package FahrenheitToCelsius;

import java.util.Scanner;


/**
 * 2. Fahrenheit to Celsius Conversion
 * - create a method that converts temperature from Fahrenheit to Celsius.
 * - write a program that for a given (by the user) body temperature, measured in Fahrenheit degrees,
 *    outputs it in Celsius degrees, with the following message: "Your body temperature in Celsius degrees is X",
 *    where X is respectively the Celsius degrees. In addition if the measured temperature in Celsius is higher
 *    than 37 degrees, the program should warn the user that they are ill, with the following message "You are ill!".
 *    (use the method created before)
 *
 * @author Maariana Valentina Mitroi
 */

public class FahrenheitToCelsius {

    private static Scanner scanner = new Scanner(System.in);
    private static final float NORMAL_BODY_TEMPERATURE = 37.f;

    public static void main(String[] args) {

        exerciseTwo();
    }

    /**
     * method to calculate from fahrenheit to celsius
     *
     * @param fahrenheit - the fahrenheit value given by the user
     * @return the value resulted after transforming the fahrenheit to celsius
     */
    public static float fahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    /**
     * method to display the Celsius temperature using the fahrenheitToCelsius() method
     */
    private static void exerciseTwo() {
        System.out.print("Enter the body temperature (in Fahrenheit): ");
        float fahrenheit = scanner.nextFloat();
        if (fahrenheitToCelsius(fahrenheit) > NORMAL_BODY_TEMPERATURE) {
            System.out.println("You are ill!");
        }
        System.out.print("Your body temperature is: " + fahrenheitToCelsius(fahrenheit) + " Celsius.");
    }

}
