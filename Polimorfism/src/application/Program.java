package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        var nProducts = sc.nextInt();
        List<Product> products = new ArrayList<>();

        for(var i = 0 ; i < nProducts ; i++){
            sc.nextLine();
            System.out.println("Product #" + (1 + i) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            var productSource = sc.nextLine();

            System.out.print("Name: ");
            var name = sc.nextLine();

            System.out.print("Price: ");
            var price = sc.nextDouble();

            switch (productSource){
                case "i":
                    System.out.print("Customs fee: ");
                    var customsFee = sc.nextDouble();
                    products.add(new ImportedProduct(name, price, customsFee));

                    break;
                case "u":
                    sc.nextLine();
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    var manufactureDate = sc.nextLine();

                    try {
                        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                        products.add(new UsedProduct(name, price, fmt.parse(manufactureDate)));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                default:
                    products.add(new Product(name, price));
                    break;
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for(var product : products){
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}