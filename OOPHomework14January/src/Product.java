
public class Product {
    private String productName;
    private float price;
    private String validityDate;
    private int weight; // it will be in grams
    private int id;
    private int stock;

    public Product(String productName, float price, String validityDate, int weight, int id, int stock) {
        this.productName = productName;
        this.price = price;
        this.validityDate = validityDate;
        this.weight = weight;
        this.id = id;
        this.stock = stock;
    }


    String getProductName() {
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
