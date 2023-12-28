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
@Entity(name = "BRN_SECONDARY_GUEST")
public class BRN_SGUEST {
    @Id
    @SequenceGenerator(name="BRN_SGUEST_seq", sequenceName = "BRN_SGUEST_SEQ", allocationSize = 1)
    @Column(nullable = false)
    @GeneratedValue(generator = "BRN_SGUEST_seq")
    private long BRN_SGUEST_ID;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "BRN_ID", nullable = false)
    private BRN brn;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "SGUEST_ID", nullable = false)
    private SecondaryGuest secondaryGuest;

}
