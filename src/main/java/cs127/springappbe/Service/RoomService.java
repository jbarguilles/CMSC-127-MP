package cs127.springappbe.Service;

import cs127.springappbe.Entities.Room;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RoomService {

    Optional<Room> findRoomByID(long roomID);

    Room toggleRoomAvailability(long roomID);

}
