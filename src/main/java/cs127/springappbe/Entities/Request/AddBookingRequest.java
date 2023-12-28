package cs127.springappbe.Entities.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs127.springappbe.Entities.BRN;
import cs127.springappbe.Entities.BRN_SGUEST;
import cs127.springappbe.Entities.PrimaryGuest;
import cs127.springappbe.Entities.SecondaryGuest;
import cs127.springappbe.Service.PGuestService;
import cs127.springappbe.Service.SGuestService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
@Setter
public class AddBookingRequest {

    @JsonProperty("primary_guest")
    private PrimaryGuest primaryGuest;

    @JsonProperty("guest_names")
    private List<SecondaryGuest> secondaryGuestList;

    @JsonProperty("booking_date")
    private String booking_date;

    @JsonProperty("check_in_date")
    private String checkin_date;

    @JsonProperty("check_out_date")
    private String checkout_date;


    public BRN mapToBooking(PGuestService pGuestService, SGuestService sGuestService){

        Optional<PrimaryGuest> optionalPrimaryGuest = pGuestService.findPrimaryGuest(this.primaryGuest.getFirstName(), this.primaryGuest.getLastName(), this.primaryGuest.getBirthday());
        PrimaryGuest primaryGuest;

        if(optionalPrimaryGuest.isEmpty()){
            primaryGuest = new PrimaryGuest(
                    this.primaryGuest.getFirstName(),
                    this.primaryGuest.getLastName(),
                    this.primaryGuest.getBirthday(),
                    this.primaryGuest.getAddress(),
                    this.primaryGuest.getContactNumber(),
                    this.primaryGuest.getEmailAddress()
            );
        }
        else{
            primaryGuest = optionalPrimaryGuest.get();
        }

        Optional<SecondaryGuest> optionalSecondaryGuest;
        SecondaryGuest secondaryGuest;

        List<BRN_SGUEST> guestList = new ArrayList<>();
        for(SecondaryGuest guest : secondaryGuestList){

            optionalSecondaryGuest = sGuestService.findSecondaryGuest(guest.getFirstName(), guest.getLastName(), guest.getBirthday());

            if(optionalSecondaryGuest.isEmpty()){
                secondaryGuest = new SecondaryGuest(
                        guest.getFirstName(),
                        guest.getLastName(),
                        guest.getBirthday(),
                        guest.getAddress(),
                        guest.getContactNumber(),
                        guest.getEmailAddress()
                );
            }
            else{
                secondaryGuest = optionalSecondaryGuest.get();
            }

            BRN_SGUEST brnSguest = new BRN_SGUEST();
            brnSguest.setSecondaryGuest(secondaryGuest);
            guestList.add(brnSguest);
        }

        BRN booking = new BRN();
        booking.setPrimaryGuest(primaryGuest);
        booking.setBooking_date(this.booking_date);
        booking.setCheckin_date(this.checkin_date);
        booking.setCheckout_date(this.checkout_date);
        booking.setGuests(guestList);


        // Set the BRN entity as the owner of the relationship
        for (BRN_SGUEST brnSguest : guestList) {
            brnSguest.setBrn(booking);
        }

        primaryGuest.getBrns().add(booking);

        return booking;
    }

}
