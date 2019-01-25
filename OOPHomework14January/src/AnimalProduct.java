
public class AnimalProduct extends Product {
    private int temperature;

    public AnimalProduct(String productName, float price, String validityDate, int weight, int stock, int temperature,
                         int id) {
        super(productName, price, validityDate, weight, id, stock);
        this.temperature = temperature;
    }
}
