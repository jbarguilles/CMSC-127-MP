package cs127.springappbe.Repository;

import cs127.springappbe.Entities.BRN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BRNRepository extends JpaRepository<BRN, Long> {
}
