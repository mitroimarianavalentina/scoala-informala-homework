import java.util.ArrayList;

/**
 * * A farm sells animal and vegetable products at the local store.
 *  * All products have on their packaging the price, validity date and weight.
 *  * The animal products in the store are the following: milk, eggs and various other products made out of milk
 *  *    (such as cheese, yogurt, sour cream).
 *  * All animal products have on their packaging storage temperature.
 *  * All vegetal products describe on their packaging a list of vitamins they contain.
 *  *
 *  * Please create a program which simulates the operations at a store.
 *  * The store has a list of item in stock.
 *  * Each item refers to a product and has a stock number (could be 0 if it's out of stock).
 *  * A product is identified uniquely by an ID.
 */

public class VegetalProducts extends  Products{
    private ArrayList<String> vitamins;

    public VegetalProducts(String productName, float price, String validityDate, int weight, int stock, ArrayList<String> vitamins) {
        super(productName, price, validityDate, weight, stock);
        this.vitamins = vitamins;
    }

    public ArrayList<String> getVitamins() {
        return vitamins;
    }

    public void addVitamin(String vitamin){
        vitamins.add(vitamin);
    }
}
