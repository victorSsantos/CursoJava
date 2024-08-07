package files;

import java.io.*;
import java.util.Scanner;

public class Program {

    public static void main (String[] args) {

        String pathIn = "/temp/in.txt";
        String pathOut = "/temp/out.txt";

        // Reading files with File and Scanner class
        System.out.println("File and Scanner:");
        try (Scanner sc = new Scanner(new File(pathIn))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        // Reading files with FileReader and BufferedReader class
        System.out.println("FileReader and BufferedReader:");
        try(BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
            var line = br.readLine();
            while(line!=null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        // Writing files with FileWriter and BufferedWriter
        System.out.println("FileWriter and BufferedWriter:");
        String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};

        var file = new File(pathOut);
        if(file.exists()) {
            if(file.delete())
                System.out.println("last file deleted");
        }

        try(BufferedWriter br = new BufferedWriter(new FileWriter(pathOut))){
            for(var line:lines){
                br.write(line);
                br.newLine();
            }
            System.out.println("new file out.txt created with success");
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        try(BufferedWriter br = new BufferedWriter(new FileWriter(pathOut, true))){
            br.write("Updated!!!");
            br.newLine();
            System.out.println("file updated");
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
