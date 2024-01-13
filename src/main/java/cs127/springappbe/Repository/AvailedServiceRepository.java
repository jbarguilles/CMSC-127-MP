package cs127.springappbe.Repository;

import cs127.springappbe.Entities.AvailedService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailedServiceRepository extends JpaRepository<AvailedService, Long> {

    List<AvailedService> findByServiceEntity_OfferedBy_RoleName(String roleName);

    List<AvailedService> findByBrn_BRNCodeAndServiceEntity_OfferedBy_RoleNameIgnoreCase(String BRNCode, String roleName);



}
