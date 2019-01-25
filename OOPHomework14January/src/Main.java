import java.util.Scanner;

/**
 * A farm sells animal and vegetable products at the local store.
 * All products have on their packaging the price, validity date and weight.
 * The animal products in the store are the following: milk, eggs and various other products made out of milk
 *    (such as cheese, yogurt, sour cream).
 * All animal products have on their packaging storage temperature.
 * All vegetal products describe on their packaging a list of vitamins they contain.
 *
 * Please create a program which simulates the operations at a store.
 * The store has a list of item in stock.
 * Each item refers to a product and has a stock number (could be 0 if it's out of stock).
 * A product is identified uniquely by an ID.
 *
 * When you run the program it should display a list of options:
 *
 * -------------------------------------------------------------
 * 1. Create product and add it to stock
 * 2. Sell product
 * 3. Display daily sales report
 * 4. Exit
 *
 * Choose an option:
 * -------------------------------------------------------------
 *
 * When the user chooses 1, the program displays:
 * -------------------------------------------------------------
 * Product type (1 - animal; 2 - vegetable):
 * -------------------------------------------------------------
 *
 * Based on the user's choice, give him/her the opportunity to input all the relevant properties,
 *     create the product and add it to the stock.
 *
 *
 * When the user chooses 2, the program displays a table (don't worry about the table's appearance,
 *      just display the data in a readable format) with the products.
 * Give the user the chance to input the product's ID and quantity.
 * The system validates the order first: searches for the product that it exists and if it exists makes sure that it's in stock.
 * If the order is valid, saves the order, with the date when it was placed (date format could be (String): "yyyy-MM-dd"),
 *      product ID and quantity.
 *
 * When the user chooses 3, give him/her the chance to enter a date (in the same format used for orders) and display
 *      a list with all the orders from that date.
 *
 * When the users chooses 4 the program ends.
 *
 *
 * Important note:
 * - if you don't manage to create and work with the program menu described above, just create programmatically
 *        (write the Java code to instantiate) a list of products of various types; then place a few orders;
 *        then display the daily report for a particular date.
 *
 * Notes:
 * - we're interested in the interfaces/classes involved in this system and their relationships
 * - write some basic behavior on your classes
 * - commit and push the project to your GitHub account
 * - submit your GitHub pullRequest URL
 *
 * Suggestions:
 * - use lists (https://docs.oracle.com/javase/8/docs/api/java/util/List.html) - get used to constantly checking the
 *          Javadoc for info on interfaces/classes/methods
 * - try to use best practices in OOP; extra kudos to you if you program against interfaces (e.g. the type of
 *          the variable pointing to the list should be List<MyClass>, but the instance's type should be ArrayList<MyClass>)
 *
 * - try to access methods in a polymorphic fashion where suitable
 */


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();

    public static void main(String[] args) {
        chooseOption();
    }

    /**
     * method to display the main menu
     */
    private static void displayMainMenu(){
        System.out.println("Choose an option:\n" +
                "-----------------------------------------\n" +
                "1. Create product and add it to stock.\n" +
                "2. Sell product.\n" +
                "3. Display daily sales.\n" +
                "4. Exit.");
    }

    /**
     * method to display the derived menu
     */
    private static void displayDerivedMenu(){
        System.out.println("Product type:\n" +
                "1. Animal.\n" +
                "2. Vegetable.\n");
    }

    /**
     * method to choose from options
     */
    private static void chooseOption(){
        boolean variable = true;
        while(variable) {
            displayMainMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    displayDerivedMenu();
                    chooseDerivedOptions();
                    break;
                case 2:
                    sellProduct();
                    break;
                case 3:
                    displayDailySales();
                    break;
                case 4:
                    variable = false;
                    break;
                default:
                    System.out.println("Invalid choice! Choose again!");
                    break;
            }
        }
    }

    /**
     * method to make the user add all the details of a animal product, and add the product to the store
     */
    private static void createAnimalProduct(){
        System.out.println("Please enter the product specifications:\nProduct Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Product Price: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Validity Date (yy-mm-dd): ");
        String validityDate = scanner.nextLine();
        System.out.println("Product Weight (grams): ");
        int weight = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Temperature to preserve it to: (Celcius)" );
        int temperature = scanner.nextInt();
        scanner.nextLine();
        store.createAnimalProduct(name, price, validityDate, weight, quantity, temperature, id);
    }

    /**
     * method to make the user add all the details of a vegetal product, and add the product to the store
     */
    private static void createVegetalProduct(){
        System.out.println("Please enter the product specifications:\nProduct Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Product Price: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Validity Date (yy-mm-dd): ");
        String validityDate = scanner.nextLine();
        System.out.println("Product Weight (grams): ");
        int weight = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        store.createVegetalProduct(name, price, validityDate, weight, quantity,id, store.addVitamins());
    }

    /**
     * method to make the user take action about the kind of product he wants to add : animal product or vegetal product
     */
    private static void chooseDerivedOptions(){
        boolean variable = true;
        while(variable) {
            int derivedOption = scanner.nextInt();
            switch (derivedOption) {
                case 1:
                    createAnimalProduct();
                    variable = false;
                    break;
                case 2:
                    createVegetalProduct();
                    variable = false;
                    break;
                    default:
                        System.out.println("Invalid choice! Choose again!");
                        displayDerivedMenu();
                        break;
            }
        }
    }

    /**
     * method to sell a product based on the id and quantity given by the user
     */
    private static void sellProduct(){
        store.displayAnimalProducts();
        store.displayVegetalProducts();
        System.out.println("What product you want to sell?\nType the id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Type the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        if (!store.sellAnimalProduct(id, quantity) && !store.sellVegetalProduct(id, quantity)){
            System.out.println("The product you are looking for, does not exist!");
        }
    }

    /**
     * method to display all the orders from a specific date chosen by the user
     */
    private static void displayDailySales(){
        if (store.ordersPlaced()){
            System.out.println("Give the date you want to see the sales from.(yy-mm-dd)");
            String date = scanner.nextLine();
            store.displayOrders(date);
        }else{
            System.out.println("No orders places do far!");        }

    }
}
