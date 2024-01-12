package cs127.springappbe.Controller;

import cs127.springappbe.Entities.Employee;
import cs127.springappbe.Entities.Request.EmployeeLoginRequest;
import cs127.springappbe.Entities.Request.UpdateEmployeeSalaryRequest;
import cs127.springappbe.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/employee")
public class EmployeeLoginController {

    private final EmployeeService employeeService;

    @PostMapping(path="/login")
    public @ResponseBody long empLogin(@RequestBody EmployeeLoginRequest employeeLoginRequest){
        Optional<Employee> enteredOptionalEmployee = employeeService.findByEmployeeID(employeeLoginRequest.getEmployeeID());
        Employee enteredEmployee;
        if(enteredOptionalEmployee.isPresent()){
            enteredEmployee = enteredOptionalEmployee.get();
            if (Objects.equals(enteredEmployee.getAccount_Password(), employeeLoginRequest.getPassword())) {
                return enteredEmployee.getEmployee_Role().getRole_Id();
            }
        }
        return 0;
    }

    @GetMapping(path = "/find")
    public Optional<Employee> findEmployeeByID(@RequestParam(value = "emp_id") Long EMP_ID){
        return employeeService.findByEmployeeID(EMP_ID);
    }

    @PutMapping(path = "/updatesalary")
    public Employee updateSalary(@RequestBody UpdateEmployeeSalaryRequest updateEmployeeSalaryRequest){
        return employeeService.updateSalary(updateEmployeeSalaryRequest);
    }

    @GetMapping(path = "/all")
    public List<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }
}
