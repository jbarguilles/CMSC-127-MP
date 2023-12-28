package cs127.springappbe.Entities;

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
@Entity(name = "BRN")
public class BRN {
    @Id
    @SequenceGenerator(name="BRN_seq", sequenceName = "BRN_SEQ", allocationSize = 1)
    @Column(nullable = false)
    @GeneratedValue(generator = "BRN_seq")
    private long BRN_ID;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "PGUEST_ID", nullable = false)
    private PrimaryGuest primaryGuest;

    private String booking_date;

    private String checkin_date;

    private String checkout_date;

    @OneToMany(mappedBy = "brn", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<BRN_SGUEST> guests = new ArrayList<>();

}
