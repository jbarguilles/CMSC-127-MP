package cs127.springappbe.Service;

import cs127.springappbe.Entities.BRN;
import cs127.springappbe.Entities.Request.AddBookingRequest;
import cs127.springappbe.Entities.SecondaryGuest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BRNService {
    BRN addBooking(AddBookingRequest bookingRequest);

    Optional<BRN> findBRNByBRNID(Long BRNID);
    Optional<BRN> findBRNByBRNCode(String BRNCode);
    BRN changeBRNStatus(Long BRNID, String status);
    BRN changeBRNStatus(String BRNCode, String status);

//    List<SecondaryGuest> findSecondaryGuests(Long BRNID);
}
