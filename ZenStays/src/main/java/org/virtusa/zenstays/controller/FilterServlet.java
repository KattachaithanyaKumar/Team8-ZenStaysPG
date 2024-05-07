package org.virtusa.zenstays.controller;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.virtusa.zenstays.model.RoomModel;

import javax.servlet.annotation.*;

@WebServlet("/filter")
public class FilterServlet extends HttpServlet {

    PGManager manager = new PGManager();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String ratingParam = request.getParameter("rating");
        float rating = 0.0f; 
        if (ratingParam != null && !ratingParam.isEmpty()) {
            rating = Float.parseFloat(ratingParam);
        }
        String foodParam = request.getParameter("food");
        boolean food = false; 
        if (foodParam != null) {
            food = foodParam.equals("on");
        }

        String wifiParam = request.getParameter("wifi");
        boolean wifi = false; 
        if (wifiParam != null) {
            wifi = wifiParam.equals("on");
        }

        String parkingParam = request.getParameter("parking");
        boolean parking = false; 
        if (parkingParam != null) {
            parking = parkingParam.equals("on");
        }

        String washingParam = request.getParameter("washing");
        boolean washing = false; 
        if (washingParam != null) {
            washing = washingParam.equals("on");
        }

        // get the rooms list based on filters
        List<RoomModel> roomList = new ArrayList<>();

        if (rating != 0) {
            roomList = manager.getRoomBasedOn(rating);
        }

        request.setAttribute("roomList", roomList);
        // request.setAttribute("filtered", true);
        request.getRequestDispatcher("filtered.jsp").forward(request, response);
    }
}
