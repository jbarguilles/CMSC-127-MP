package cs127.springappbe.Repository;

import cs127.springappbe.Entities.PrimaryGuest;
import cs127.springappbe.Entities.SecondaryGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;
import java.util.List;

@Repository
public interface PGuestRepository extends JpaRepository<PrimaryGuest,Long> {

    Optional<PrimaryGuest> findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndBirthday(String firstName, String lastName, Date birthday);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);


    default Optional<PrimaryGuest> findPrimaryGuest(String firstName, String lastName, Date birthday){
        return findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndBirthday(firstName, lastName, birthday);
    }

//    @Query(
//            value = "",
//            nativeQuery = true
//    )  List<SecondaryGuest> findSecondaryGuests(Long PGuestID);

}
