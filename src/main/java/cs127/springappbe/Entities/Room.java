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
@Entity(name = "ROOM")
public class Room {

    @Id
    @SequenceGenerator(name="ROOM_seq", sequenceName = "ROOM_SEQ", allocationSize = 1)
    @Column(name = "ROOM_ID", nullable = false)
    @GeneratedValue(generator = "ROOM_seq")
    private long roomID;

    private int roomNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ROOM_TYPE_ID", nullable = false)
    private RoomType roomType;

    private String isOccupied;

    @OneToOne(mappedBy = "room")
    @JsonIgnore
    private BookedRoom bookedRoom;

}
