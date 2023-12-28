package cs127.springappbe.Repository;

import cs127.springappbe.Entities.BRN_SGUEST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BRN_SGuestRepository extends JpaRepository<BRN_SGUEST, Long> {
}
