package cs127.springappbe.Service;

import cs127.springappbe.Entities.AvailedService;
import cs127.springappbe.Repository.AvailedServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AvailedServiceEntityServiceImpl implements  AvailedServiceEntityService{

    private final AvailedServiceRepository availedServiceRepository;

    @Override
    public List<AvailedService> findAvailedServicesByType(String brnCode, String serviceType) {
        return availedServiceRepository.findByBrn_BRNCodeAndServiceEntity_OfferedBy_RoleNameIgnoreCase(brnCode, serviceType);
    }

}
