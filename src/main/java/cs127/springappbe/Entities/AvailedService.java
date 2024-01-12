package cs127.springappbe.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "AVAILED_SERVICE")
public class AvailedService {

    @Id
    @SequenceGenerator(name="Availed_Service_seq", sequenceName = "AVAILED_SERVICE_SEQ", allocationSize = 1)
    @Column(name = "AVAILED_SERVICE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Availed_Service_seq")
    private long availedServiceID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private ServiceEntity serviceEntity;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "BRN_ID", nullable = false)
    private BRN brn;

    @OneToOne(optional = false)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee employee;

}
