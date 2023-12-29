package cs127.springappbe.Entities.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs127.springappbe.Entities.PrimaryGuest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class AddGuestRequest {

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

    public PrimaryGuest mapToPrimaryGuest() {

        PrimaryGuest primaryGuest = new PrimaryGuest();
        primaryGuest.setFirstName(this.firstName);
        primaryGuest.setFirstName(this.lastName);
        primaryGuest.setFirstName(this.birthday);
        primaryGuest.setFirstName(this.address);
        primaryGuest.setFirstName(this.contactNumber);
        primaryGuest.setFirstName(this.emailAddress);

        return primaryGuest;
    }

}
