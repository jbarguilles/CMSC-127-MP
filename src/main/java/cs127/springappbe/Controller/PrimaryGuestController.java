package cs127.springappbe.Controller;

import cs127.springappbe.Entities.Employee;
import cs127.springappbe.Entities.PrimaryGuest;
import cs127.springappbe.Service.PGuestService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/pguests")
public class PrimaryGuestController {
    @Qualifier("PGuestServiceImpl")
    private final PGuestService primaryGuestService;

    @GetMapping(path = "/all")
    public List<PrimaryGuest> findAllPGuest(){
        return primaryGuestService.findAllPGuest();
    }
}
