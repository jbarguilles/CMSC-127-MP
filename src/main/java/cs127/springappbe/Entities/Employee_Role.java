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
@Entity(name = "EMPLOYEE_ROLES")
public class Employee_Role {
    @Id
    @SequenceGenerator(name="EMP_ROLES_seq", sequenceName = "EMP_ROLES_SEQ", allocationSize = 1)
    @Column(nullable = false)
    @GeneratedValue(generator = "EMP_ROLES_seq")
    private long Role_Id;

    private String Role_Name;
}
