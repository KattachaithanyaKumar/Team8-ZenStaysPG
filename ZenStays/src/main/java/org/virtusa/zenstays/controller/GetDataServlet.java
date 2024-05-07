package org.virtusa.zenstays.controller;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;

import org.virtusa.zenstays.model.RoomModel;

import javax.servlet.annotation.*;

@WebServlet("/GetDataServlet")
public class GetDataServlet extends HttpServlet {
    PGManager manager = new PGManager();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        List<RoomModel> roomList = manager.getAllRooms();
        request.setAttribute("roomList", roomList);
    }

}