package interfaces.model.services;

import interfaces.model.entities.CarRental;
import interfaces.model.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private final double pricePerDay;
    private final double pricePerHour;
    private final TaxService taxService;

    public RentalService(double pricePerDay, double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental){
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes/60.0;

        double basicPayment = hours<=12 ? this.pricePerHour * Math.ceil(hours) : this.pricePerDay * Math.ceil(hours/24);
        carRental.setInvoice(new Invoice(basicPayment, this.taxService.tax(basicPayment)));
    }
}
