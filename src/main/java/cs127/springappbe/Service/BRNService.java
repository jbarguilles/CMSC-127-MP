package cs127.springappbe.Service;

import cs127.springappbe.Entities.BRN;
import cs127.springappbe.Entities.Request.AddBookingRequest;
import cs127.springappbe.Entities.SecondaryGuest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BRNService {
    BRN addBooking(AddBookingRequest bookingRequest);

//    List<SecondaryGuest> findSecondaryGuests(Long BRNID);
}
