package cs127.springappbe.Repository;

import cs127.springappbe.Entities.Employee;
import cs127.springappbe.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    //Optional<Employee> findByEmployeeID(long EmployeeID);
    Employee findByEmployeeID(long EmployeeID);
}
