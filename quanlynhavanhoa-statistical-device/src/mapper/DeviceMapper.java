package mapper;

import java.sql.ResultSet;
import model.Device;

public class DeviceMapper implements RowMapper<Device>{

	@Override
	public Device mapRow(ResultSet rs) {
		try {
			Device device = new Device();
			device.setId(rs.getInt("id"));
			device.setName(rs.getString("name"));
			device.setPrice(rs.getLong("price"));
			return device;
		} catch (Exception e) {
			return null;
		}
	}

}
