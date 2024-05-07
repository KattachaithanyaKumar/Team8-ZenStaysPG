package org.virtusa.zenstays.controller;

import org.virtusa.zenstays.dao.OwnerPgDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PGInfoServlet")
public class OwnerAddPg extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/pgAdd.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html;charset=UTF-8");

        String name = servletRequest.getParameter("name");
        String city = servletRequest.getParameter("city");
        String address = servletRequest.getParameter("address");
        String type = servletRequest.getParameter("type");
        String status = servletRequest.getParameter("status");
        String rating = servletRequest.getParameter("rating");
        String imgUrl = servletRequest.getParameter("img_url");

        OwnerPgDAO addPg = new OwnerPgDAO();
        addPg.addingPgs(name, city, address, type, status, rating, imgUrl, servletRequest, servletResponse);

    }

}

