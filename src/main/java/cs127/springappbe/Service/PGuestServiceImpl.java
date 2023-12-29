package cs127.springappbe.Service;

import cs127.springappbe.Entities.PrimaryGuest;
import cs127.springappbe.Repository.PGuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PGuestServiceImpl implements PGuestService{

    private final PGuestRepository pGuestRepository;

    @Override
    public Optional<PrimaryGuest> findPrimaryGuest(String firstName, String lastName, Date birthday) {
        return pGuestRepository.findPrimaryGuest(firstName, lastName, birthday);
    }
}
