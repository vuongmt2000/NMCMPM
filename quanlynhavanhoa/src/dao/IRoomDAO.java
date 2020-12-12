package dao;

import java.util.List;
import model.Room;

public interface IRoomDAO extends GenericDAO<Room>{
	List<Room> findAll();
	Long insertRoom(Room room);
	void updateRoom(Room room);
	Room findOne(Long id);
	void delete(Long id);
}
