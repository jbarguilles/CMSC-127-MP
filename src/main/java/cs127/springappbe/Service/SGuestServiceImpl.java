package cs127.springappbe.Service;

import cs127.springappbe.Entities.SecondaryGuest;
import cs127.springappbe.Repository.SGuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SGuestServiceImpl implements SGuestService{

    private final SGuestRepository sGuestRepository;

    @Override
    public Optional<SecondaryGuest> findSecondaryGuest(String firstName, String lastName, Date birthday) {
        return sGuestRepository.findSecondaryGuest(firstName, lastName, birthday);
    }

    @Override
    public List<SecondaryGuest> findSecondaryGuests(Long BRNID){
        return sGuestRepository.findSecondaryGuests(BRNID);
    }
}
