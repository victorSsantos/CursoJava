package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data");
        Client client = new Client();

        System.out.print("Name: ");
        var name = sc.nextLine();

        System.out.print("Email: ");
        var email = sc.nextLine();

        System.out.print("Birth Date (DD/MM/YYYY): ");
        String birth = sc.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        client.setName(name);
        client.setEmail(email);
        try {
            Date data = format.parse(birth);
            client.setBirthDate(data);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Order order = new Order(new Date(), OrderStatus.PROCESSING, client);
        System.out.println("Enter Order Data:");
        System.out.println("Status: " + order.getStatus());

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            System.out.println("Enter #" + i + " item data:");
            sc.nextLine();
            System.out.print("Product Name: ");
            var productName = sc.nextLine();

            System.out.print("Product Price: ");
            var productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            var quantityProduct = sc.nextInt();

            OrderItem item = new OrderItem(productName, productPrice, quantityProduct);
            order.addItem(item);
        }

        order.printSummary();

    }
}