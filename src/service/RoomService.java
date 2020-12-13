package service;

import model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getListRoom();

    Room findByFloorAndNumberFloor(Integer floor, Integer numberFloor, Integer status);

    Room findById(Long id);

    List<Room> findAll();
}
