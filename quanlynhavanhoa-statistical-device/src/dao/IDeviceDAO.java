package dao;

import java.util.List;
import model.Device;

public interface IDeviceDAO extends GenericDAO<Device>{
	List<Device> findAll();
	Long insertDevice(Device device);
	void updateDevice(Device device);
	Device findOne(Long id);
	void delete(Long id);
}
