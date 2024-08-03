package application;

import entities.Employee;
import entities.OutsourceEmployee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        var nEmployees = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for(var i = 0 ; i < nEmployees ; i++){
            sc.nextLine();
            System.out.println("Employee #" + (1 + i) + " data:");
            System.out.print("Outsourced (y/n)? ");
            var isOutsource = sc.nextLine();

            System.out.print("Name: ");
            var name = sc.nextLine();

            System.out.print("Hour: ");
            var hour = sc.nextInt();

            System.out.print("Value per hour: ");
            var valuePerHour = sc.nextDouble();

            if(isOutsource.equals("y")){
                System.out.print("Additional charge: ");
                var additionalCharge = sc.nextDouble();
                employees.add(new OutsourceEmployee(name, hour, valuePerHour, additionalCharge));
            }
            else{
                employees.add(new Employee(name, hour, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("PAYMENTS:");
        for(var employee : employees){
            System.out.println(employee.getName() + " - $ " + String.format("%.2f",employee.payment()));
        }

        sc.close();
    }
}