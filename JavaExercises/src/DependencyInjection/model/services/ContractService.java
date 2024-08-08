package DependencyInjection.model.services;

import DependencyInjection.model.entities.Contract;
import DependencyInjection.model.entities.Installment;
import DependencyInjection.model.interfaces.OnlinePaymentService;

import java.util.ArrayList;

public class ContractService {

    OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months){
        ArrayList<Installment> installments = new ArrayList<>();
        Double baseAmount = contract.getTotalValue() / months;

        for(var i = 1 ; i <= months ; i++){
            Double amount = baseAmount + this.paymentService.interest(baseAmount, i);
            amount += this.paymentService.paymentFee(amount);
            installments.add(new Installment(contract.getDate().plusMonths(i), amount));
        }
        contract.setInstallments(installments);
    }
}
