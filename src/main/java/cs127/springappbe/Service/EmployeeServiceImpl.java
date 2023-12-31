package cs127.springappbe.Service;

import cs127.springappbe.Entities.Employee;
import cs127.springappbe.Repository.EmployeeRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    @Override
//    public Optional<Employee> findByEmployeeID(long EmployeeID) {
//        return employeeRepository.findByEmployeeID(EmployeeID);
//    }
    public Employee findByEmployeeID(long EmployeeID) {
        return employeeRepository.findByEmployeeID(EmployeeID);
    }
}
