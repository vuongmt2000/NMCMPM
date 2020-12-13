package dao;


import model.Room;

import java.util.List;

public interface IRoomDAO extends GenericDAO<Room>{
	List<Room> findAll();
	Long insertRoom(Room room);
	void updateRoom(Room room);
	Room findOne(Long id);
	void delete(Long id);
	Room findByFloorAndNumberFloor(Integer floor, Integer numberFloor, Integer status);
}
