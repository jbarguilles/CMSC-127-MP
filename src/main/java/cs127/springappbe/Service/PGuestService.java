package cs127.springappbe.Service;

import cs127.springappbe.Entities.PrimaryGuest;
import cs127.springappbe.Entities.SecondaryGuest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface PGuestService {

    Optional<PrimaryGuest> findPrimaryGuest(String firstName, String lastName, Date Birthday);
    List<PrimaryGuest> findAllPGuest();
//    List<SecondaryGuest> findSecondaryGuests(Long PGuestID);

}
