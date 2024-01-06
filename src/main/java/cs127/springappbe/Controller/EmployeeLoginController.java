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
}
