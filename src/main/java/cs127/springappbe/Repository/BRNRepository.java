package cs127.springappbe.Repository;

import cs127.springappbe.Entities.BRN;
import cs127.springappbe.Entities.SecondaryGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BRNRepository extends JpaRepository<BRN, Long> {

//    @Query(
//            value = "SELECT SG.* FROM BRN " +
//                    "FULL JOIN SPRINGAPPUSER.BRN_SGUEST BS on BRN.BRN_ID = BS.BRN_ID " +
//                    "FULL JOIN SPRINGAPPUSER.SECONDARY_GUEST SG on BS.SGUEST_ID = SG.SGUEST_ID " +
//                    "WHERE BS.BRN_ID=?1",
//            nativeQuery = true
//    )
//    List<SecondaryGuest> findSecondaryGuests(Long BRNID);

}
