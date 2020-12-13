package service;

import model.Device;

import java.util.List;

public interface DeviceService {
    List<Device> getAllDevice();

    Device findByName(String name, Integer status);

    Device findById(Long id);

    List<Device> getAll();
}
