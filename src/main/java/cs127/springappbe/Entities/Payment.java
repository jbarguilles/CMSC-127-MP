package cs127.springappbe.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "PAYMENT")
public class Payment {

    @Id
    @SequenceGenerator(name="PAYMENT_seq", sequenceName = "PAYMENT_SEQ", allocationSize = 1)
    @Column(name="PAYMENT_ID", nullable = false)
    @GeneratedValue(generator = "PAYMENT_seq")
    private long paymentID;

    @OneToOne(optional = false)
    @JoinColumn(name = "BRN_ID", nullable = false)
    private BRN brn;

    private String paymentType;

    private String cardNumber;

    private String cvv;

    private Date expirationDate;

    private String status;

}
