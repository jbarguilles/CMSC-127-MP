package cs127.springappbe.Service;

import cs127.springappbe.Entities.ServiceEntity;
import org.springframework.stereotype.Service;

@Service
public interface ServiceEntityService {

    ServiceEntity findServiceByID(long serviceID);

}
