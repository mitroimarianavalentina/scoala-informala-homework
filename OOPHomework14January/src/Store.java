import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Store {
    private ArrayList<AnimalProducts> arrayAnimalProducts;
    private ArrayList<Orders> arrayOrders;

    public Store() {
        arrayAnimalProducts = new ArrayList<>();
        arrayOrders = new ArrayList<>();
    }

    public void createAnimalProduct(String productName, float price, String validityDate,
                                    int weight, int stock, int temperature){

        arrayAnimalProducts.add(new AnimalProducts(productName, price, validityDate, weight, stock, temperature));
    }

    public ArrayList<AnimalProducts> getAnimalProducts() {
        return arrayAnimalProducts;
    }

    /**
     * method to sell a product
     * @param id - product's id that will be sold
     * @param quantity - the quantity we want to sell
     */
    public void sellProduct(int id, int quantity){
        for (AnimalProducts animalProducts : arrayAnimalProducts){
            // if in the array of animal products exists a product with this id, and we have the appropriate quantity
            if((animalProducts.getId() == id) && (animalProducts.getStock() >= quantity)){
                // the product will be added in an array of orders
                arrayOrders.add(new Orders(getDate(), id, quantity));
                // set the new stock of the product after selling
                animalProducts.setStock(animalProducts.getStock() - quantity);
            }else if((animalProducts.getId() == id) && (animalProducts.getStock() < quantity)){
                // if the product exists, but there is no stock
                System.out.println("Insufficient stock for the product!!!");
            }else {
                System.out.println("The product you are looking for, does not exist!");
            }
        }
    }

    /**
     * method to get the order date
     * @return tge local date, at the time of teh order
     */
    private LocalDate getDate(){
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate date1 = currentTime.toLocalDate();
        return  date1;
    }


}
