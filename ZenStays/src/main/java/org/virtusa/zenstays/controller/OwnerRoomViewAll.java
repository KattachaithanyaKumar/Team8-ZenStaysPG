package org.virtusa.zenstays.controller;



import org.virtusa.zenstays.dao.OwnerPgDAO;
import org.virtusa.zenstays.dao.OwnerRoomDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RoomViewAllServlet")
public class OwnerRoomViewAll extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OwnerRoomDAO ownerDao = new OwnerRoomDAO();
        ownerDao.getRoomsInfo(req, resp);


    }
}

