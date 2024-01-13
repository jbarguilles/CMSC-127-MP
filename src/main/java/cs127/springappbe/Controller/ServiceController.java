package cs127.springappbe.Controller;

import cs127.springappbe.Entities.BRN;
import cs127.springappbe.Entities.SecondaryGuest;
import cs127.springappbe.Entities.ServiceEntity;
import cs127.springappbe.Service.ServiceEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/service")
public class ServiceController {

    private final ServiceEntityService serviceEntityService;

    @GetMapping(path="/getByRole")
    public List<ServiceEntity> getServicesByEmployeeRole(@RequestParam(value="employeeRole") String employeeRole){
        return serviceEntityService.findServicesByEmployeeRole(employeeRole);
    }

}
