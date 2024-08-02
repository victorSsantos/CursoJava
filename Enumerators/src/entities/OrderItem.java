package entities;

public class OrderItem {
    private final Integer quantity;
    private final Double price;
    private final Product product;

    public OrderItem(String nameProduct, Double price, Integer quantity) {
         this.quantity = quantity;
         this.product = new Product(nameProduct, price);
         this.price = subTotal();
    }

    public Double subTotal(){
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return product.getName() +
                ", $" + String.format("%.2f", product.getPrice()) +
                ", Quantity: " + quantity +
                ", Subtotal: $" + String.format("%.2f", price);
    }
}