package dao;

import model.Room_Device;

import java.util.List;

public interface IRoomDeviceDAO extends GenericDAO<Room_Device>{
	List<Room_Device> findAll();
	Long insertRoom_Device(Room_Device room_Device);
	void updateRoom_Device(Room_Device room_Device);
	Room_Device findOne(Long id);
	void delete(Long id);
	Room_Device findByRoomIdAndDeviceId(Long roomId, Long deviceId);
}
