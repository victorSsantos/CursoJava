package entities;

public class OutsourceEmployee extends Employee {

    private double additionalCharge;

    public OutsourceEmployee(String name, Integer hour, Double valuePerHour, Double additionalCharge) {
        super(name, hour, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public Double payment(){
        return super.payment()+(additionalCharge*1.1);
    }
}
