package cs127.springappbe.Service;

import cs127.springappbe.Entities.PrimaryGuest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public interface PGuestService {

    Optional<PrimaryGuest> findPrimaryGuest(String firstName, String lastName, Date Birthday);

}
