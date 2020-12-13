package service.service_impl;

import dao.impl.RoomDeviceDAO;
import model.Room_Device;
import service.RoomDeviceService;

public class RoomDeviceServiceImpl implements RoomDeviceService {

    private RoomDeviceDAO roomDeviceDAO = new RoomDeviceDAO();


    @Override
    public Room_Device findByRoomIdAndDeviceId(Long roomId, Long deviceId) {
        return roomDeviceDAO.findByRoomIdAndDeviceId(roomId, deviceId);
    }
}
