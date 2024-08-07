package polimorfism.entities;

public class ImportedProduct extends Product {

    private final Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag(){
        return super.name +
                " $ " + String.format("%.2f",super.price + customsFee) +
                " (Customs fee: $ " +
                String.format("%.2f", customsFee) + ")";
    }
}
