package cs127.springappbe.Controller;

import cs127.springappbe.Entities.Employee;
import cs127.springappbe.Entities.Request.EmployeeLoginRequest;
import cs127.springappbe.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/employee")
public class EmployeeLoginController {

    @Qualifier("EmployeeServiceImpl")
    private final EmployeeService employeeService;

    @PostMapping(path="/login")
    public @ResponseBody long empLogin(@RequestBody EmployeeLoginRequest employeeLoginRequest){
        Optional<Employee> enteredOptionalEmployee = employeeService.findByEmployeeID(employeeLoginRequest.getEmployeeID());

        Employee enteredEmployee = enteredOptionalEmployee.get();
        //Employee enteredEmployee = employeeService.findByEmployeeID(employeeLoginRequest.getEmployeeID());

        if (Objects.equals(enteredEmployee.getAccount_Password(), employeeLoginRequest.getPassword())) {
            return employeeLoginRequest.getEmployeeID();
        }
        return 0;
    }
}
