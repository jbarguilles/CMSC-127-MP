package cs127.springappbe.Repository;

import cs127.springappbe.Entities.SecondaryGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SGuestRepository extends JpaRepository<SecondaryGuest, Long> {
    Optional<SecondaryGuest> findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndBirthday(String firstName, String lastName, Date birthday);


    default Optional<SecondaryGuest> findSecondaryGuest(String firstName, String lastName, Date birthday){
        return findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndBirthday(firstName, lastName, birthday);
    }

    @Query(
            value = "SELECT SG.* FROM BRN " +
                    "FULL JOIN BRN_SGUEST BS on BRN.BRN_ID = BS.BRN_ID " +
                    "FULL JOIN SECONDARY_GUEST SG on BS.SGUEST_ID = SG.SGUEST_ID " +
                    "WHERE BS.BRN_ID=?1",
            nativeQuery = true
    )
    List<SecondaryGuest> findSecondaryGuests(Long BRNID);
}
