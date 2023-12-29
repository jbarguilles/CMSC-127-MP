package cs127.springappbe.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "PRIMARY_GUEST")
public class PrimaryGuest {

    @Id
    @SequenceGenerator(name="pguest_seq", sequenceName = "PGUEST_SEQ", allocationSize = 1)
    @Column(name = "PGUEST_ID", nullable = false)
    @GeneratedValue(generator = "pguest_seq")
    private long PGuest_ID;

    private String firstName;

    private String lastName;

    private Date birthday;

    private String address;

    private String contactNumber;

    private String emailAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "primaryGuest", orphanRemoval = true)
    private List<BRN> brns = new ArrayList<>();

    public PrimaryGuest(String firstName, String lastName,
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
