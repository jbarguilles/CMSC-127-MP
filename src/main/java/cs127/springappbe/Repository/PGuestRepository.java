package cs127.springappbe.Repository;

import cs127.springappbe.Entities.PrimaryGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PGuestRepository extends JpaRepository<PrimaryGuest,Long> {
    Optional<PrimaryGuest> findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndBirthday(String firstName, String lastName, String birthday);

    default Optional<PrimaryGuest> findPrimaryGuest(String firstName, String lastName, String birthday){
        return findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndBirthday(firstName, lastName, birthday);
    }

}
