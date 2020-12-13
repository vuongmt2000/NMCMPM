package dao;


import model.Device;

import java.util.List;

public interface IDeviceDAO extends GenericDAO<Device>{
	List<Device> findAll();

	Long insertDevice(Device device);

	void updateDevice(Device device);

	Device findOne(Long id);

	void delete(Long id);

	Device findByName(String name, Integer status);

}
