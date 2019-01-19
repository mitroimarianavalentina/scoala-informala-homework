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

public class Products {
    private String productName;
    private float price;
    private String validityDate;
    private int weight; // it will be in grams
    private int id = 0;
    private int stock;

    public Products(String productName, float price, String validityDate, int weight, int stock) {
        this.productName = productName;
        this.price = price;
        this.validityDate = validityDate;
        this.weight = weight;
        id++;
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public int getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
