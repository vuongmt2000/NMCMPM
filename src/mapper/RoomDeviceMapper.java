package mapper;

import java.sql.ResultSet;
import model.Room_Device;

public class RoomDeviceMapper implements RowMapper<Room_Device>{

	@Override
	public Room_Device mapRow(ResultSet rs) {
		try {
			Room_Device rd = new Room_Device();
			rd.setRoom_id(rs.getInt("room_id"));
			rd.setDevice_id(rs.getInt("device_id"));
			rd.setQuantity(rs.getInt("quantity"));
			rd.setBroken_quantity(rs.getInt("broken_quantity"));
			return rd;
		} catch (Exception e) {
			return null;
		}
	}

}
