package generics.application;

import generics.entities.Product;
import generics.services.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args){

        String path = "/temp/products.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Product> products = new ArrayList<>();
            String line = br.readLine();

            do{
                if(line!=null && !line.isEmpty()){
                    String[] fields = line.split(",");
                    products.add(new Product(fields[0],Double.parseDouble(fields[1])));
                }
                line = br.readLine();
            }
            while(line!=null);

            for(var item : products){
                System.out.println(item);
            }

            System.out.println();
            System.out.println("Most expensive:");
            System.out.println(CalculationService.max(products));
        }
        catch(IOException e){
            System.out.println("Unexpected error");
        }
    }
}
