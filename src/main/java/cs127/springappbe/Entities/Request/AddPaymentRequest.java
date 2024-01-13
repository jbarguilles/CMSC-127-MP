package cs127.springappbe.Entities.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs127.springappbe.Entities.BRN;
import cs127.springappbe.Entities.Payment;
import cs127.springappbe.Entities.PrimaryGuest;
import cs127.springappbe.Service.BRNService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
@Setter
public class AddPaymentRequest {

    @JsonProperty("brn_code")
    private String brnCode;

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("card_number")
    private String cardNumber;

    @JsonProperty("cvv")
    private String cvv;

    @JsonProperty("expiration_date")
    private String expirationDate;

    public Payment mapToPayment(BRNService brnService) {

        Payment payment = new Payment();

        Optional<BRN> optionalBRN = brnService.findBRNByBRNCode(this.brnCode);

        if(optionalBRN.isPresent()){
            payment.setBrn(optionalBRN.get());
        }

        payment.setPaymentType(this.paymentType);
        payment.setCardNumber(this.cardNumber);
        payment.setCvv(this.cvv);
        if((this.expirationDate) == ""){
            payment.setExpirationDate(null);
        } else{
            payment.setExpirationDate(Date.valueOf(this.expirationDate));
        }
        payment.setStatus("SUCCESS");

        return payment;
    }


}
