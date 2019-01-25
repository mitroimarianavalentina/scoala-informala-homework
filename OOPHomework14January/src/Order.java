import java.time.LocalDate;

public class Order {
    private LocalDate date;
    private int id;
    private  int quantity;

    public Order(LocalDate date, int id, int quantity) {
        this.date = date;
        this.id = id;
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

}
