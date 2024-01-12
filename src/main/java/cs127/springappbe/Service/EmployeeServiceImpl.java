package cs127.springappbe.Service;

import cs127.springappbe.Entities.Employee;
import cs127.springappbe.Entities.Request.UpdateEmployeeSalaryRequest;
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
    public Optional<Employee> findByEmployeeID(long employeeID) {
        return employeeRepository.findByEmployeeID(employeeID);
    }

    @Override
    public Employee updateSalary(UpdateEmployeeSalaryRequest updateEmployeeSalaryRequest) {
        Employee toUpdate = employeeRepository.findByEmployeeID(updateEmployeeSalaryRequest.getEmployeeID()).get();
        double num = Double.parseDouble(updateEmployeeSalaryRequest.getSalary());
        toUpdate.setSalary(num);
        return employeeRepository.save(toUpdate);
    }
//    public Employee findByEmployeeID(long EmployeeID) {
//        return employeeRepository.findByEmployeeID(EmployeeID);
//    }
}
