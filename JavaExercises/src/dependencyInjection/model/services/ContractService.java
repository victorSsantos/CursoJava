package dependencyInjection.model.services;

import dependencyInjection.model.entities.Contract;
import dependencyInjection.model.entities.Installment;
import dependencyInjection.model.interfaces.OnlinePaymentService;

import java.time.LocalDate;

public class ContractService {

    OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months){
        LocalDate basicDate = contract.getDate();
        double basicAmount = contract.getTotalValue() / months;

        for(var i = 1 ; i <= months ; i++){
            var interest = this.paymentService.interest(basicAmount, i);
            var paymentFee = this.paymentService.paymentFee(basicAmount + interest);
            var amountTotal = basicAmount + interest + paymentFee;

            contract.getInstallments().add(new Installment(basicDate.plusMonths(i), amountTotal));
        }
    }
}
