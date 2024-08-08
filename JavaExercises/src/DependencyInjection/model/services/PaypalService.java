package DependencyInjection.model.services;

import DependencyInjection.model.interfaces.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService {

    public Double paymentFee(Double amount) {
        return amount * 0.02;
    }

    public Double interest(Double amount, Integer months) {
        return amount * 0.01 * months ;
    }
}
