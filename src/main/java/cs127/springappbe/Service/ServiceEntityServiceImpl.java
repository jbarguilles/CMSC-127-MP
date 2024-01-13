package cs127.springappbe.Service;

import cs127.springappbe.Entities.ServiceEntity;
import cs127.springappbe.Repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServiceEntityServiceImpl implements ServiceEntityService{

    private final ServiceRepository serviceRepository;

    @Override
    public ServiceEntity findServiceByID(long serviceID) {

        if(serviceRepository.findByServiceID(serviceID).isPresent()){
            return serviceRepository.findByServiceID(serviceID).get();
        }
        else {
            return null;
        }

    }

    @Override
    public List<ServiceEntity> findServicesByEmployeeRole(String employeeRole) {
        return serviceRepository.findByOfferedBy_RoleName(employeeRole);
    }

}
