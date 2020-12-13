package dao.impl;



import dao.IRoomDeviceDAO;
import mapper.RoomDeviceMapper;
import model.Room_Device;

import java.util.List;

public class RoomDeviceDAO extends AbstractDAO<Room_Device> implements IRoomDeviceDAO {
	
	@Override
	public List<Room_Device> findAll() {
		String sql = "SELECT * FROM room_device";
		return query(sql, new RoomDeviceMapper());
	}

	@Override
	public Long insertRoom_Device(Room_Device device) {
		StringBuilder sql = new StringBuilder("INSERT INTO room_device");
		sql.append("(device_id, room_id, quantity, broken_quantity)");
		sql.append(" VALUES(?, ?, ?, ?)");
		return insert(sql.toString(), device.getDevice_id(), device.getRoom_id(), device.getQuantity(), device.getBroken_quantity());
	}

	@Override
	public void updateRoom_Device(Room_Device device) {
		StringBuilder sql = new StringBuilder("UPDATE room_device SET device_id = ?, quantity = ?, ");
		sql.append("broken_quantity = ? WHERE room_id = ?");
		update(sql.toString(), device.getDevice_id(), device.getRoom_id(), device.getQuantity(), device.getBroken_quantity());
	}

	@Override
	public Room_Device findOne(Long id) {
		String sql = "SELECT * FROM room_device WHERE id = ?" ;
		List<Room_Device> list = query(sql, new RoomDeviceMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM room_device WHERE id = ?";
		update(sql, id);
	}

	@Override
	public Room_Device findByRoomIdAndDeviceId(Long roomId, Long deviceId) {
		String sql = "SELECT * FROM room_device WHERE room_id = ? AND device_id = ?";
		List<Room_Device> list = query(sql, new RoomDeviceMapper(), roomId, deviceId);
		return list.isEmpty() ? null : list.get(0);
	}
}
