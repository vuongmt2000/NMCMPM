package dao.impl;

import dao.IRoomDAO;
import java.util.List;
import mapper.RoomMapper;
import model.Room;

public class RoomDAO extends AbstractDAO<Room> implements IRoomDAO {

	@Override
	public List<Room> findAll() {
		String sql = "SELECT * FROM room";
		return query(sql, new RoomMapper());
	}

	@Override
	public Long insertRoom(Room room) {
		StringBuilder sql = new StringBuilder("INSERT INTO room");
		sql.append("(floor, numer_floor, floor, status, price)");
		sql.append(" VALUES(?, ?, ?, ?)");
		return insert(sql.toString(), room.getFloor(), room.getNumber_floor(), room.getFloor(),room.getStatus(), room.getPrice());
	}

	@Override
	public void updateRoom(Room room) {
		StringBuilder sql = new StringBuilder("UPDATE room SET floor = ?, numer_floor = ?, floor = ?,");
		sql.append(" status = ?, price = ?  WHERE id = ?");
		update(sql.toString(), room.getFloor(), room.getNumber_floor(), room.getFloor(),room.getStatus(), room.getPrice(), room.getId());
	}

	@Override
	public Room findOne(Long id) {
		String sql = "SELECT * FROM room WHERE id = ?" ;
		List<Room> list = query(sql, new RoomMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM room WHERE id = ?";
		update(sql, id);
	}

}
