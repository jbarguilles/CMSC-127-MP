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
@Entity(name = "BOOKED_ROOM")
public class BookedRoom {

    @Id
    @SequenceGenerator(name="BOOKED_ROOM_seq", sequenceName = "BOOKED_ROOM_SEQ", allocationSize = 1)
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BOOKED_ROOM_seq")
    private long Booked_Room_ID;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "BRN_ID", nullable = false)
    private BRN brn;

    @OneToOne(optional = false)
    @JoinColumn(name = "ROOM_ID", nullable = false)
    private Room room;

}
