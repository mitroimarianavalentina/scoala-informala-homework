import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//
//        /** 1. Calculate the sum of the first 100 numbers higher than 0. */
//        System.out.println(" The sum of the first 100 numbers higher than 0 is: " + sum());
//
//
//        /** 2. Display the smallest number from a collection of numbers. */
//        System.out.println("Enter the length of the collection:");
//        int length = scanner.nextInt();
//        System.out.println("The smallest number from the collection is: " + min(length));
//
//
//        /** 3. Display the max digit from a number. Read the number from keyboard. */
//        System.out.println("Enter the number: ");
//        int n = scanner.nextInt();
//        System.out.println("Max digit of the number " + n + " is: " + digit(n));
//
//
//        /**  4.Check if a number is a palindrome (e.g. 1221, 34143). */
//        System.out.print("Enter the number you want to check: ");
//        int number = scanner.nextInt();
//        if (palindrome(number)){
//            System.out.println("The number is palindrome");
//        }else{
//            System.out.println("The number is  NOT palindrome");
//        }
//
//        /** 5. Display all the prime numbers lower than a given number. */
//        System.out.print("Enter the ending stop of the prime numbers: ");
//        int x = scanner.nextInt();
//        displayAllPrimeNumbers(x);
//
//        /** 6. Input the dimensions of a rectangle and display area and perimeter. */
//        System.out.print("Enter the width of the rectangle: ");
//        int w = scanner.nextInt();
//        System.out.print("Enter the height of the rectangle: ");
//        int h = scanner.nextInt();
//        System.out.println("The area of the rectangle is: " + area(w, h));
//        System.out.print("The perimeter of the rectangle is: " + perimeter(w, h));

//        /** 7. Input the length of the side of a square, and display its area.  Produce an error message if the length is negative. */
//        System.out.print("Enter the side of the square: ");
//        int squareSide = scanner.nextInt();
//        if (squareSide > 0) {
//            System.out.println("The area of teh square is: " + squareArea(squareSide));
//        }else if (squareSide == 0){
//            System.out.println("Error! The side can not be zero!");
//        }else{
//            System.out.println("Error! You introduced a negative side!");
//        }

//        /** 8. Input 3 numbers, and display the biggest. */
//        System.out.print("Enter the first number: ");
//        int first = scanner.nextInt();
//        System.out.print("Enter the second number: ");
//        int second = scanner.nextInt();
//        System.out.print("Enter the third number: ");
//        int third = scanner.nextInt();
//        System.out.print(biggestNumber (first, second, third));


        /** 9. Input 2 values: start and finish, then display the numbers from start to finish. */
        System.out.print("Enter the start: ");
        int start = scanner.nextInt();
        System.out.print("Enter the finish: ");
        int finish = scanner.nextInt();
        if (finish >= start){
            display(start, finish);
        }else{
            System.out.println("Error! Starting point should be lower than the finish!");
        }

    }


    /**
     * 1. Calculate the sum of the first 100 numbers higher than 0.
     * @return the sum
     */
    private static int sum (){
        int sum = 0;
        for (int i = 1; i <= 100; i++){
            sum += i;
        }
        return sum;
    }

    /**
     * 2. Display the smallest number from a collection of numbers.
     * @return - the minimum of the collection
     */
    private static int min(int length){
        int m = Integer.MAX_VALUE;

        System.out.println("Enter numbers into the collection. ");
        for (int  i = 0; i < length; i++) {
            int number = scanner.nextInt();
            if (m > number){
                m = number;
            }
        }
        return m;
    }

    /**
     * 3. Display the max digit from a number. Read the number from keyboard.
     * @return - the max digit from the number read from the keyboard
     */
    private static int digit(int number){
        int max = Integer.MIN_VALUE;

        while (number > 0){
            if (number%10 > max){
                max = number%10;
            }
            number = number / 10;
        }
        return max;
    }

    /**
     * 4.Check if a number is a palindrome (e.g. 1221, 34143).
     * @param number
     * @return true - if the number is palindrome, or false - otherwise
     */
    private static boolean palindrome (int number ){
        int aux = 0;
        int no = number;
        while (number > 0){
            aux = (aux * 10) + (number % 10);
            number = number / 10;
        }
        if (aux  == no){
            return true;
        }else {
            return false;
        }
    }

    /**
     *  5. Display all the prime numbers lower than a given number.
     *
     * method to check if a number is prime or not
     * @param number - the number that we check to see if it is prime or not
     * @return true - if the number is prime, and false otherwise
     */
    private static boolean prime (int number){
        boolean is = true;
        for (int i = 2; i <= number/2; i++){
            if (number%i==0){
                is = false;
                break;
            }
        }
        return is;
    }

    /**
     * method to display all the prime numbers lower than a given number
     * @param n - we'll display all the prime numbers lower than this parameter n
     */
    private static void displayAllPrimeNumbers(int n){
        for (int i = 2; i < n; i++){
            if (prime(i)){
                System.out.printf(i + " ");
            }
        }
    }

    /**
     *  6. Input the dimensions of a rectangle and display area and perimeter.
     *
     * calculates the area of the rectangle
     * @param l - the width
     * @param L - the length
     * @return the area
     */
    private static int area(int l, int L){
        return l * L;
    }

    /**
     * calculates the perimeter of the rectangle
     * @param l - the width
     * @param L - the length
     * @return the perimeter
     */
    private static int perimeter(int l, int L){
        return 2*(l + L);
    }

    /**
     * 7. Input the length of the side of a square, and display its area.  Produce an error message if the length is negative.
     *
     * calculates the area of a square
     * @param l - is the side of the square
     * @return the area of the square
     */
    private static int squareArea(int l){
        return l*l;
    }


    /**
     * 8. Input 3 numbers, and display the biggest.
     * @param a
     * @param b
     * @param c
     * @return the biggest number of the three
     */
    private static String biggestNumber(int a, int b, int c){
        if ((a > b) && (a > c)){
            return ("The biggest number between " + a + ", " + b + ", " + c + ", is:" + a);
        }else if (b > a && b > c){
            return ("The biggest number between " + a + ", " + b + ", " + c + ", is:" + b);
        }else{
            return ("The biggest number between " + a + ", " + b + ", " + c + ", is:" + c);
        }
    }

    /**
     * 9. Input 2 values: start and finish, then display the numbers from start to finish.
     *
     * @param start
     * @param finish
     */
    private static void display(int start, int finish){
        for (int i = start; i <= finish; i++){
            System.out.print(i + ", ");
        }
    }
}
