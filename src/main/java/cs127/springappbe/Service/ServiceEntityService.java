package cs127.springappbe.Service;

import cs127.springappbe.Entities.ServiceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceEntityService {

    ServiceEntity findServiceByID(long serviceID);

    List<ServiceEntity> findServicesByEmployeeRole(String employeeRole);

}
