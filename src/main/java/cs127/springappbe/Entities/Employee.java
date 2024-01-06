package cs127.springappbe.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "EMPLOYEE")
public class Employee {

    @Id
    @SequenceGenerator(name="emp_seq", sequenceName = "EMP_SEQ", allocationSize = 1)
    @Column(name = "EMPLOYEE_ID", nullable = false)
    @GeneratedValue(generator = "emp_seq")
    private long employeeID;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Employee_Role employee_Role;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SUPERVISOR_ID")
    private Employee employeeSupervisor;

    private String First_Name;

    private String Last_Name;

    private long Salary;

    private String Account_Password;
}
