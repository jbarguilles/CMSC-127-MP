package cs127.springappbe.Repository;

import cs127.springappbe.Entities.Employee;
import cs127.springappbe.Entities.Employee_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRoleRepository extends JpaRepository<Employee_Role,Long> {



}
