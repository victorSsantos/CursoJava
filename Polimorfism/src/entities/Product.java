package entities;

public class Product {

    protected final String name;
    protected final Double price;

    public Product(String name, Double price ) {
        this.price = price;
        this.name = name;
    }

    public String priceTag(){
        return name + " $ " + String.format("%.2f",price);
    }
}
