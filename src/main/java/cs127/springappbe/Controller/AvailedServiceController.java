package cs127.springappbe.Controller;

import cs127.springappbe.Entities.AvailedService;
import cs127.springappbe.Entities.SecondaryGuest;
import cs127.springappbe.Service.AvailedServiceEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/availedService")
public class AvailedServiceController {

    private final AvailedServiceEntityService availedServiceEntityService;

    @GetMapping(path="/getByType")
    public List<AvailedService> findAvailedServicesByType(@RequestParam(value="BRNCode") String BRNCode,
                                                          @RequestParam(value="serviceType") String serviceType){
        return availedServiceEntityService.findAvailedServicesByType(BRNCode, serviceType);
    }

}
