package org.virtusa.zenstays.controller;

import org.virtusa.zenstays.dao.OwnerPgDAO;
import org.virtusa.zenstays.dao.OwnerRoomDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RoomInfoServlet")
public class OwnerAddRoom extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/roomAdd.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html;charset=UTF-8");

        boolean availability = Boolean.parseBoolean(servletRequest.getParameter("availability"));
//        int pgId = Integer.parseInt(servletRequest.getParameter("pg_id"));
        String pgIdParam = servletRequest.getParameter("pg_id");
        // Convert pg_id to integer
        int pgId = pgIdParam != null ? Integer.parseInt(pgIdParam) : -1;
        int noOfBeds = Integer.parseInt(servletRequest.getParameter("no_of_beds"));

        OwnerRoomDAO addPg = new OwnerRoomDAO();
        addPg.addingRooms(availability, pgId, noOfBeds, servletRequest, servletResponse);

    }


}
