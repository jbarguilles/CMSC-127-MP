package cs127.springappbe.Controller;

import cs127.springappbe.Entities.BRN;
import cs127.springappbe.Entities.Request.AddBookingRequest;
import cs127.springappbe.Entities.SecondaryGuest;
import cs127.springappbe.Service.BRNService;
import cs127.springappbe.Service.SGuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/brn")
public class BRNController {

    @Qualifier("BRNServiceImpl")
    private final BRNService brnService;

    @Qualifier("SGuestServiceImpl")
    private final SGuestService sGuestService;

    @PostMapping(path="/add")
    public @ResponseBody BRN addBooking(@RequestBody AddBookingRequest bookingToAdd){
        return brnService.addBooking(bookingToAdd);
    }

    @GetMapping(path="/secondaryguests")
    public List<SecondaryGuest> findSecondaryGuests(@RequestParam(value="BRNID") Long BRNID){
        return sGuestService.findSecondaryGuests(BRNID);
    }

}
