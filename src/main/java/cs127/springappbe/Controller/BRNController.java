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

@CrossOrigin
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

    @GetMapping(path="/getbyID")
    public BRN getBRNDetailsByID(@RequestParam(value="BRNID") Long BRNID){
        return brnService.findBRNByBRNID(BRNID).get();
    }

    @GetMapping(path="/getbyCODE")
    public BRN getBRNDetailsByCode(@RequestParam(value="BRNCODE") String BRNCODE){
        return brnService.findBRNByBRNCode(BRNCODE).get();
    }
    @PutMapping(path="/changestatusID")
    public BRN changeStatus(@RequestParam(value="BRNID") Long BRNID, @RequestParam(value="status") String status){
        return brnService.changeBRNStatus(BRNID, status);
    }

    @PutMapping(path="/changestatusCODE")
    public BRN changeStatus(@RequestParam(value="BRNCODE") String BRNCODE, @RequestParam(value="status") String status){
        return brnService.changeBRNStatus(BRNCODE, status);
    }
}
