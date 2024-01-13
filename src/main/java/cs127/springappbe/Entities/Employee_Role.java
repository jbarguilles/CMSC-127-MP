package cs127.springappbe.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "EMPLOYEE_ROLES")
public class Employee_Role {
    @Id
    @SequenceGenerator(name="EMP_ROLES_seq", sequenceName = "EMP_ROLES_SEQ", allocationSize = 1)
    @Column(name="ROLE_ID", nullable = false)
    @GeneratedValue(generator = "EMP_ROLES_seq")
    private long roleID;

    private String roleName;

    @OneToMany(mappedBy = "offeredBy")
    private List<ServiceEntity> servicesOffered = new ArrayList<>();

}
