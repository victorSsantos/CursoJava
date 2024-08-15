package streams.application;

import streams.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {

    public static void main(String[] args) {

        /* Algorithm to print fibonacci sequence
        Stream<Long> fibonacci = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1] , p[0] + p[1]}).map( p -> p[0]);
        System.out.println(Arrays.toString(fibonacci.limit(10).toArray()));
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        String path = sc.nextLine();
        System.out.print("Enter salary: ");
        Double salaryInput = sc.nextDouble();

        try(BufferedReader buffer = new BufferedReader(new FileReader(path))){

            List<Employee> employees = new ArrayList<>();
            String line = buffer.readLine();

            while(line!=null){
                var fields = line.split(",");
                employees.add(new Employee(fields[0],fields[1],Double.parseDouble(fields[2])));
                line = buffer.readLine();
            }

            employees.stream()
                    .filter(e -> e.getSalary() > salaryInput)
                    .map(Employee::getEmail)
                    .sorted()
                    .toList()
                    .forEach(System.out::println);

            Double sum = employees.stream()
                    .filter( e -> e.getName().toLowerCase().charAt(0) == 'm')
                    .map(Employee::getSalary)
                    .reduce(0.0, Double::sum);

            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f",sum));
        }
        catch(IOException e){
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
