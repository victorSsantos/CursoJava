package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

    private final Date manufactureDate;

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag(){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        return super.name + " (used) " +
                " $ " + String.format("%.2f",super.price) +
                " (Manufacture date: $ " + fmt.format(manufactureDate) + ")";
    }
}
