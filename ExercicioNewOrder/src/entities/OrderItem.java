package entities;

public class OrderItem {
    private int quantity;
    private double price;
    private String name;

    private Product product;


    public OrderItem(int quantity, double price, String name, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }


    public double subTotal(){
        return quantity * price;
    }


    @Override
    public String toString() {
        return name
                + ", $" + String.format("%.2f", price)
                + ", Quantity: " + quantity
                + ", Subtotal: $" + String.format("%.2f", subTotal());

    }
}
