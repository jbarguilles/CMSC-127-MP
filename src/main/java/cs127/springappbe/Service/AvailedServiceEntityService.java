package cs127.springappbe.Service;

import cs127.springappbe.Entities.AvailedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AvailedServiceEntityService {

    List<AvailedService> findAvailedServicesByType(String brnCode, String serviceType);

}
