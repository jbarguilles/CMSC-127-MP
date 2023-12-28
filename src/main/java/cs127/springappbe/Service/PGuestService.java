package cs127.springappbe.Service;

import cs127.springappbe.Entities.PrimaryGuest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PGuestService {

    public Optional<PrimaryGuest> findPrimaryGuest(String firstName, String lastName, String Birthday);

}
