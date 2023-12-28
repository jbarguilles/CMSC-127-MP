package cs127.springappbe.Controller;

import cs127.springappbe.Entities.BRN;
import cs127.springappbe.Entities.Request.AddBookingRequest;
import cs127.springappbe.Service.BRNService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/brn")
public class BRNController {

    @Qualifier("BRNServiceImpl")
    private final BRNService brnService;

    @PostMapping(path="/add")
    public @ResponseBody BRN addBooking(@RequestBody AddBookingRequest bookingToAdd){
        return brnService.addBooking(bookingToAdd);
    }


}
