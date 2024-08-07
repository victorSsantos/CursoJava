package interfaces.application;

import interfaces.model.entities.CarRental;
import interfaces.model.entities.Vehicle;
import interfaces.model.services.BrazilTaxService;
import interfaces.model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter data rental: ");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        System.out.print("Pick up date (dd/mm/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Return date (dd/mm/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Enter the price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter the price per day: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
        rentalService.processInvoice(cr);

        System.out.println("INVOICE: ");
        System.out.println("Basic Payment: " + String.format("%.2f",cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f",cr.getInvoice().getTax()));
        System.out.println("Total Payment: " + String.format("%.2f",cr.getInvoice().getTotalPayment()));

        sc.close();
    }
}
