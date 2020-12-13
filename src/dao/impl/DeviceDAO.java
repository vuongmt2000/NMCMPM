package dao.impl;


import dao.IDeviceDAO;
import mapper.DeviceMapper;
import model.Device;

import java.util.List;

public class DeviceDAO extends AbstractDAO<Device> implements IDeviceDAO {

	@Override
	public List<Device> findAll() {
		String sql = "SELECT * FROM device";
		return query(sql, new DeviceMapper());
	}

	@Override
	public Long insertDevice(Device device) {
		StringBuilder sql = new StringBuilder("INSERT INTO device");
		sql.append("(name, price)");
		sql.append(" VALUES(?, ?)");
		return insert(sql.toString(), device.getName(), device.getPrice());
	}

	@Override
	public void updateDevice(Device device) {
		StringBuilder sql = new StringBuilder("UPDATE device SET name = ?, price = ? WHERE id = ?");
		update(sql.toString(), device.getName(), device.getPrice(), device.getId());
	}

	@Override
	public Device findOne(Long id) {
		String sql = "SELECT * FROM device WHERE id = ?" ;
		List<Device> list = query(sql, new DeviceMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM device WHERE id = ?";
		update(sql, id);
	}

	@Override
	public Device findByName(String name, Integer status) {
		String sql = "SELECT * FROM device WHERE name LIKE " + "'%" + name + "%'" + " AND status = ?";
		List<Device> devices = query(sql, new DeviceMapper(), status);
		return devices.isEmpty() ? null : devices.get(0);
	}

}
