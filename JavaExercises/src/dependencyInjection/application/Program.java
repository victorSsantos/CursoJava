package dependencyInjection.application;

import dependencyInjection.model.entities.Contract;
import dependencyInjection.model.services.ContractService;
import dependencyInjection.model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter Contract Data:");
        System.out.print("Number: ");
        int contractNumber = sc.nextInt();
        System.out.print("Date (dd/mm/yyyy): ");
        LocalDate dateContract = LocalDate.parse(sc.next(), fmt);
        System.out.print("Value: ");
        Double value = sc.nextDouble();

        Contract contract = new Contract(contractNumber,dateContract,value);

        System.out.print("Enter the number of installments: ");
        int months = sc.nextInt();

        ContractService cs = new ContractService(new PaypalService());
        cs.processContract(contract,months);

        if(contract.getInstallments()!=null){
            System.out.println("INSTALLMENTS:");
            for(var installment:contract.getInstallments()){
                System.out.println(installment);
            }
        }

        sc.close();
    }
}
