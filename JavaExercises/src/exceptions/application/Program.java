package exceptions.application;

import exceptions.model.entities.Reservation;
import exceptions.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.print("Room: ");
            int numberRoom = sc.nextInt();

            System.out.print("Check-in (DD/MM/YYYY): ");
            Date checkIn = fmt.parse(sc.next());

            System.out.print("Check-out (DD/MM/YYYY): ");
            Date checkOut = fmt.parse(sc.next());

            Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            boolean updateDate;

            do {
                sc.nextLine();
                System.out.print("Would you like to update reservation dates (Y/N)? ");
                var update = sc.nextLine();

                if(update.equalsIgnoreCase("y")){
                    System.out.println("Enter dates to update the reservation: ");

                    System.out.print("Check-in (DD/MM/YYYY): ");
                    checkIn = fmt.parse(sc.next());

                    System.out.print("Check-out (DD/MM/YYYY): ");
                    checkOut = fmt.parse(sc.next());

                    reservation.updateDates(checkIn, checkOut);
                    System.out.println("Reservation: " + reservation);
                    updateDate = true;
                }
                else{
                    System.out.println("Reservation confirmed");
                    updateDate = false;
                }
                System.out.println();
            }
            while(updateDate);
        }
        catch(InputMismatchException e){
            System.out.println("Invalid number room format");
        }
        catch (ParseException e) {
            System.out.println("Invalid Date format");
        }
        catch (DomainException e) {
            System.out.println("Error reservation: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
