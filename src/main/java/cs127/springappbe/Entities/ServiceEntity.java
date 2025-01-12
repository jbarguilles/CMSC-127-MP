package cs127.springappbe.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "SERVICE")
public class ServiceEntity {

    @Id
    @SequenceGenerator(name="Service_seq", sequenceName = "SERVICE_SEQ", allocationSize = 1)
    @Column(name = "SERVICE_ID", nullable = false)
    @GeneratedValue(generator = "Service_seq")
    private long serviceID;

    private String serviceName;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Employee_Role offeredBy;

}
