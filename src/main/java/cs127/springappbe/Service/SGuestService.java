package cs127.springappbe.Service;

import cs127.springappbe.Entities.SecondaryGuest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SGuestService {

    Optional<SecondaryGuest> findSecondaryGuest(String firstName, String lastName, String Birthday);

}
