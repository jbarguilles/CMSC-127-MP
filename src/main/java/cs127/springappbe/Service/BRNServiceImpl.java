package cs127.springappbe.Service;

import cs127.springappbe.Entities.BRN;
import cs127.springappbe.Entities.Request.AddBookingRequest;
import cs127.springappbe.Repository.BRNRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BRNServiceImpl implements BRNService{

    private final BRNRepository brnRepository;

    @Qualifier("PGuestServiceImpl")
    private final PGuestService pGuestService;

    @Qualifier("SGuestServiceImpl")
    private final SGuestService sGuestService;

    @Override
    public BRN addBooking(AddBookingRequest bookingRequest) {
        return brnRepository.save(bookingRequest.mapToBooking(pGuestService, sGuestService));
    }
}
