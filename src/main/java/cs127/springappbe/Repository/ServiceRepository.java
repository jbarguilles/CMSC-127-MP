package cs127.springappbe.Repository;

import cs127.springappbe.Entities.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

    Optional<ServiceEntity> findByServiceID(long serviceID);

    List<ServiceEntity> findByOfferedBy_RoleName(String roleName);



}
