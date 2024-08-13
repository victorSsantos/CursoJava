package collections.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String fullPath = sc.nextLine();
        Map<String,Integer> computedVotes = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fullPath))){

            String line = reader.readLine();
            while(line!=null && !line.isEmpty()) {
                var fields = line.split(",");
                if (fields.length > 1) {
                    Integer totalVotes = computedVotes.get(fields[0]);
                    Integer votes = Integer.parseInt(fields[1]);
                    totalVotes = totalVotes!=null ? totalVotes+votes : votes;
                    computedVotes.put(fields[0], + totalVotes);
                }
                line = reader.readLine();
            }

            int totalVotes = 0;
            for(String key:computedVotes.keySet()){
                System.out.println(key + ": " + computedVotes.get(key));
                totalVotes+=computedVotes.get(key);
            }
            System.out.println("------------------");
            System.out.println(totalVotes + " computed votes");
        }
        catch (IOException e){
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
