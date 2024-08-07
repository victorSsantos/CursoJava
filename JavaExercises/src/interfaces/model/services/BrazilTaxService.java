package interfaces.model.services;

public class BrazilTaxService implements TaxService {

    public double tax(double amount){
        return amount>100.00 ? amount*0.15 : amount*0.2;
    }
}
