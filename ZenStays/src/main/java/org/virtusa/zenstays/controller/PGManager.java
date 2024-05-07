package org.virtusa.zenstays.controller;

// import com.team.zenstays.persistance.RoomDAO;

import java.util.List;

import org.virtusa.zenstays.dao.PGRoomDAO;
import org.virtusa.zenstays.model.RoomModel;

public class PGManager {
    PGRoomDAO roomDAO = new PGRoomDAO();
    public List<RoomModel> getAllRooms() {
        return roomDAO.readRooms();
    }

    public List<RoomModel> getRoomBasedOn(float rating) {
        return roomDAO.findRoomsBasedOn(rating);
    }
    public List<RoomModel> getRoomBasedOn(String rating, boolean food) {
        return null;
    }
    public List<RoomModel> getRoomBasedOn(String rating, boolean food, boolean wifi) {
        return null;
    }


}

