package cs127.springappbe.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("address")
    private String address;

    @JsonProperty("contact_number")
    private String contactNumber;

    @JsonProperty("email_address")
    private String emailAddress;

    public SecondaryGuest(String firstName, String lastName,
                          String birthday, String address,
                          String contactNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
    }
}
