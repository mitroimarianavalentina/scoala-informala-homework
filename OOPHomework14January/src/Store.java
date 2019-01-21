import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Store {
    //member to hold the list of AnimalProduct
    private ArrayList<AnimalProduct> arrayAnimalProduct;
    //member to hold the list of AnimalProduct
    private ArrayList<VegetalProduct> arrayVegetalProduct;
    private static final Pattern LETTERS = Pattern.compile("\\p{Alpha}+");

    private ArrayList<Orders> arrayOrders;

    /**
     * constructor of the class
     */
    public Store() {
        arrayAnimalProduct = new ArrayList<>();
        arrayVegetalProduct = new ArrayList<>();
        arrayOrders = new ArrayList<>();
    }

    /**
     * method to add a new product to the Store
     *
     * @param productName  - the name of the product
     * @param price        - the price of the product
     * @param validityDate - the validity date of the product
     * @param weight       - the weight of the product
     * @param stock        - the stock of the product
     * @param temperature  - the optimal temperature to preserve the product
     * @param id           - the id of the product
     */
    public void createAnimalProduct(String productName, float price, String validityDate,
                             int weight, int stock, int temperature, int id) {
        // check the ID, we don't want to add duplicates
        if (duplicateID(id)) {
            //create a new AnimalProduct
            arrayAnimalProduct.add(new AnimalProduct(productName, price, validityDate, weight, stock, temperature, id));
        } else {
            System.out.println("The product " + productName +
                    " was not added to the Store!!!");
            System.out.println("The id given to " + productName +
                    " is already given to another product.");
        }
    }

    /**
     * method to add a new product to the Store
     *
     * @param productName  - the name of the product
     * @param price        - the price of the product
     * @param validityDate - the validity date of the product
     * @param weight       - the weight of the product
     * @param stock        - the stock of the product
     * @param vitamins     - the list of vitamins
     * @param id           - the id of the product
     */
    public void createVegetalProduct(String productName, float price, String validityDate,
                              int weight, int stock, int id, ArrayList<String> vitamins) {
        // check the ID, we don't want to add duplicates
        if (duplicateID(id)) {
            //create a new AnimalProduct
            arrayVegetalProduct.add(new VegetalProduct(productName, price, validityDate, weight, stock, id, vitamins));
        } else {
            System.out.println("The product " + productName +
                    " was not added to the Store!!!");
            System.out.println("The id given to " + productName +
                    " is already given to another product.");
        }
    }

    /**
     * method to sell a product
     *
     * @param id       - product's id that will be sold
     * @param quantity - the quantity we want to sell
     */
    public boolean sellAnimalProduct(int id, int quantity) {
        boolean found = false;
        for (AnimalProduct animalProduct : arrayAnimalProduct) {
            // if in the array of animal products exists a product with this id, and we have the appropriate quantity
            if ((animalProduct.getId() == id) && (animalProduct.getStock() >= quantity)) {
                // the product will be added in an array of orders
                arrayOrders.add(new Orders(localDate(), id, quantity));
                // set the new stock of the product after selling
                animalProduct.setStock(animalProduct.getStock() - quantity);
                found = true;
            } else if ((animalProduct.getId() == id) && (animalProduct.getStock() < quantity)) {
                // if the product exists, but there is no stock
                System.out.println("Insufficient stock for the product!!!");
                found = true;
            }
        }
        return found;
    }

    /**
     * method to sell a vegetal product
     *
     * @param id       - product's id that will be sold
     * @param quantity - the quantity we want to sell
     */
    public  boolean sellVegetalProduct(int id, int quantity) {
        boolean found = false;
        for (VegetalProduct vegetalProduct : arrayVegetalProduct) {
            // if in the array of animal products exists a product with this id, and we have the appropriate quantity
            if ((vegetalProduct.getId() == id) && (vegetalProduct.getStock() >= quantity)) {
                // the product will be added in an array of orders
                arrayOrders.add(new Orders(localDate(), id, quantity));
                // set the new stock of the product after selling
                vegetalProduct.setStock(vegetalProduct.getStock() - quantity);
                found = true;
            } else if ((vegetalProduct.getId() == id) && (vegetalProduct.getStock() < quantity)) {
                // if the product exists, but there is no stock
                System.out.println("Insufficient stock for the product!!!");
                found = true;
            }
        }
        return found;
    }

    /**
     * method to avoid registering a duplicate id
     *
     * @param id - the id we want to check
     * @return true - if the id is already given to another product; and false - otherwise
     */
    private boolean duplicateID(int id) {
        for (AnimalProduct animalProduct : arrayAnimalProduct) {
            if (animalProduct.getId() == id) {
                return false;
            }
        }
        return true;
    }

    /**
     * method to display all the animal products from the store
     */
    public void displayAnimalProducts() {
        System.out.println("ID\tName\t\t\tQuantity\n------------------------------------");
        for (AnimalProduct animalProduct : arrayAnimalProduct) {
            System.out.println(animalProduct.getId() + "\t" +
                    animalProduct.getProductName() + "\t\t" +
                    animalProduct.getStock());
        }
    }

    /**
     * method to display all the vegetal products from the store
     */
    public void displayVegetalProducts() {
        for (VegetalProduct vegetalProduct : arrayVegetalProduct) {
            System.out.println(vegetalProduct.getId() + "\t" +
                    vegetalProduct.getProductName() + "\t\t" +
                    vegetalProduct.getStock());
        }
    }

    /**
     * method to display the orders from a specific date
     */
    public void displayOrders(String date) {
        System.out.println("Orders placed on " + date + ":\n");
        System.out.println("ID\tQuantity\n----------------------");
        for (Orders orders : arrayOrders) {
            if (orders.getDate().toString().equals(date)) {
                System.out.println(
                        orders.getId() + "\t" +
                                orders.getQuantity());
            }
        }
    }

// TODO sa adaug cantitate noua pt acelasi produs

    /**
     * method to get the local date
     */
    private LocalDate localDate() {
        Date input = new Date();
        return (input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    /**
     * method to check if there are any orders placed
     *
     * @return - true if we have at least one order placed, and false otherwise
     */
    public boolean ordersPlaced() {
        return (arrayOrders.size() > 0);
    }



    /**
     * method to allow the user to input the vitamins for each product
     *
     * @return the arrayList of vitamins
     */
    public ArrayList<String> addVitamins() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> vitamins = new ArrayList<>();
        while (addMoreVitamins()) {
            System.out.println("Type the vitamin!");
            String vit = sc.nextLine();
            if (isAlpha(vit)) {
                vitamins.add(vit);
            } else {
                System.out.println("what you entered is not a vitamin!!!");
            }
        }
        return vitamins;
    }

    /**
     * method to let the user choose how many vitamins wants to add to the product
     *
     * @return true - if the user wants more vitamins to be added, and false otherwise
     */
    private boolean addMoreVitamins() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to add vitamins? Press Y - Yes / N - No");
        if (sc.nextLine().toUpperCase().equals("Y")) {
            return true;
        } else if (sc.nextLine().toUpperCase().equals("N")) {
            return false;
        }
        return false;
    }

    /**
     * method to update the product stock
     *
     * @return true - if the user wants to update the product's stock, and false otherwise
     */
    private boolean addStock() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to update the stock? Press Y - Yes / N - No");
        if (sc.nextLine().toUpperCase().equals("Y")) {
            return true;
        } else if (sc.nextLine().toUpperCase().equals("N")) {
            return false;
        }
        return false;
    }

    /**
     * method to check if the keyboard input is a String or not
     *
     * @param text - the text we want to check
     * @return true - if it is a String, and false otherwise
     */
    private boolean isAlpha(String text) {
        return LETTERS.matcher(text).matches();
    }
}
