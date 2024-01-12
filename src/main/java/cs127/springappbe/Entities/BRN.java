package cs127.springappbe.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Date;
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
    @Column(name = "BRN_ID", nullable = false)
    @GeneratedValue(generator = "BRN_seq")
    private long BRNID;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "PGUEST_ID", nullable = false)
    private PrimaryGuest primaryGuest;

    private Date booking_date;

    private Date checkin_date;

    private Date checkout_date;
    private String status;
    private String BRNCode;

    @OneToMany(mappedBy = "brn", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<BRN_SGUEST> guests = new ArrayList<>();


    @OneToMany(mappedBy = "brn", cascade = CascadeType.PERSIST)
    private List<BookedRoom> bookedRooms = new ArrayList<>();

}
