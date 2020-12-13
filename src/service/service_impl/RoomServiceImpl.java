package service.service_impl;

import dao.impl.RoomDAO;
import model.Room;
import service.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    private RoomDAO roomDAO = new RoomDAO();


    @Override
    public List<Room> getListRoom() {
        return roomDAO.findAll();
    }

    @Override
    public Room findByFloorAndNumberFloor(Integer floor, Integer numberFloor, Integer status) {
        return roomDAO.findByFloorAndNumberFloor(floor, numberFloor, status);
    }

    @Override
    public Room findById(Long id) {
        return roomDAO.findOne(id);
    }

    @Override
    public List<Room> findAll() {
        return roomDAO.findAll().isEmpty() ? null : roomDAO.findAll();
    }
}
