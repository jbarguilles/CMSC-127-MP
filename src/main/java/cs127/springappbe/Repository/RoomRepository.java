package cs127.springappbe.Repository;

import cs127.springappbe.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Long> {

    Optional<Room> findByRoomID(long roomID);



}
