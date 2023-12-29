package cs127.springappbe.Service;

import cs127.springappbe.Entities.SecondaryGuest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public interface SGuestService {

    Optional<SecondaryGuest> findSecondaryGuest(String firstName, String lastName, Date Birthday);

}
