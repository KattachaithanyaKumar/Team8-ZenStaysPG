package org.virtusa.zenstays.controller;



import org.virtusa.zenstays.dao.OwnerPgDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PGViewAllServlet")
public class OwnerPgViewAll extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OwnerPgDAO ownerDao = new OwnerPgDAO();
        ownerDao.getPgsInfo(req, resp);


    }
}

