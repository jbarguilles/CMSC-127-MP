package cs127.springappbe.Controller;

import cs127.springappbe.Entities.BRN;
import cs127.springappbe.Entities.Payment;
import cs127.springappbe.Entities.Request.AddBookingRequest;
import cs127.springappbe.Entities.Request.AddPaymentRequest;
import cs127.springappbe.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(path="/add")
    public @ResponseBody Payment addPayment(@RequestBody AddPaymentRequest paymentToAdd){
        return paymentService.addPayment(paymentToAdd);
    }

}
