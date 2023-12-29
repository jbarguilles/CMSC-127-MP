package cs127.springappbe.Service;

import cs127.springappbe.Entities.Room;
import cs127.springappbe.Repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public Optional<Room> findRoomByID(long roomID) {
        return roomRepository.findByRoomID(roomID);
    }

    @Override
    public Room toggleRoomAvailability(long roomID) {
        Room room = roomRepository.findByRoomID(roomID).get();

        if(room.getIsOccupied() == "YES"){
            room.setIsOccupied("NO");
        }
        else{
            room.setIsOccupied("YES");
        }

        return roomRepository.save(room);
    }


}
