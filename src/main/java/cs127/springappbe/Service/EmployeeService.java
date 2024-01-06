package cs127.springappbe.Service;

import cs127.springappbe.Entities.Employee;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EmployeeService {
    Optional<Employee> findByEmployeeID(long EmployeeID);
    //Employee findByEmployeeID(long EmployeeID);
}
