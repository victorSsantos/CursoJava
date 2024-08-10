package generics.application;

import generics.entities.Product;
import generics.services.ListHelperService;

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

            while(line!=null && !line.isEmpty()){
                String[] fields = line.split(",");
                products.add(new Product(fields[0],Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            ListHelperService.print(products);
            System.out.println();
            System.out.println("Most expensive:");
            System.out.println(ListHelperService.max(products));
        }
        catch(IOException e){
            System.out.println("Unexpected error");
        }
    }
}
