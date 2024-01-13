package cs127.springappbe.Service;

import cs127.springappbe.Entities.Payment;
import cs127.springappbe.Entities.Request.AddPaymentRequest;
import cs127.springappbe.Repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(AddPaymentRequest addPaymentRequest) {
        return paymentRepository.save(addPaymentRequest.mapToPayment());
    }
}
