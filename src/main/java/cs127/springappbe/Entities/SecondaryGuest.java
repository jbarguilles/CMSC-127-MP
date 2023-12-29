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
@Entity(name = "SECONDARY_GUEST")
public class SecondaryGuest {

    @Id
    @SequenceGenerator(name="sguest_seq", sequenceName = "SGUEST_SEQ", allocationSize = 1)
    @Column(nullable = false)
    @GeneratedValue(generator = "sguest_seq")
    private long SGuest_ID;

    private String firstName;

    private String lastName;

    private Date birthday;

    private String address;

    private String contactNumber;

    private String emailAddress;

    public SecondaryGuest(String firstName, String lastName,
                          Date birthday, String address,
                          String contactNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
    }
}
