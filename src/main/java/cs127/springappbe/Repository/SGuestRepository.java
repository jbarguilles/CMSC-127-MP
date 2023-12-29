package cs127.springappbe.Repository;

import cs127.springappbe.Entities.SecondaryGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface SGuestRepository extends JpaRepository<SecondaryGuest, Long> {
    Optional<SecondaryGuest> findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndBirthday(String firstName, String lastName, Date birthday);


    default Optional<SecondaryGuest> findSecondaryGuest(String firstName, String lastName, Date birthday){
        return findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndBirthday(firstName, lastName, birthday);
    }


}
