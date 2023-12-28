package cs127.springappbe.Service;

import cs127.springappbe.Entities.BRN;
import cs127.springappbe.Entities.Request.AddBookingRequest;
import org.springframework.stereotype.Service;

@Service
public interface BRNService {

    public BRN addBooking(AddBookingRequest bookingRequest);
}
