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
@Entity(name = "ROOM_TYPE")
public class RoomType {

    @Id
    @SequenceGenerator(name="ROOM_TYPE_seq", sequenceName = "ROOM_TYPE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    @GeneratedValue(generator = "ROOM_TYPE_seq")
    private long Room_Type_ID;

    private String roomType;

    private String description;

    private Double price;

    private int maxGuests;

    private Double area;

    @JsonIgnore
    @OneToMany(mappedBy = "roomType")
    private List<Room> rooms = new ArrayList<>();

}
