package cs127.springappbe.Service;

import cs127.springappbe.Entities.Payment;
import cs127.springappbe.Entities.Request.AddPaymentRequest;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    Payment addPayment(AddPaymentRequest addPaymentRequest);
}
