package org.virtusa.zenstays.dao;

import org.virtusa.zenstays.model.PGModel;
import org.virtusa.zenstays.utility.DataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnerPgDAO {

    public void addingPgs(String name, String city, String address, String type, String status, String rating, String imgUrl,
                          HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {
        Connection con = null;
        PreparedStatement st = null;
        int statusUpdate = 0;

        try {
            DataSource ds = new DataSource();
            con = ds.getConnection();

            st = con.prepareStatement("insert into pg (name, city, address, type, status, rating, img_url) values (?,?,?,?,?,?,?)");
            st.setString(1, name);
            st.setString(2, city);
            st.setString(3, address);
            st.setString(4, type);
            st.setString(5, rating);
            st.setString(6, status);
            st.setString(7, imgUrl);
            statusUpdate = st.executeUpdate();
        }catch(SQLException e1) {
            e1.printStackTrace();
        }
        if(statusUpdate != 0) {
            System.out.println("Success & ("+statusUpdate+") rows affected");
            servletResponse.sendRedirect(servletRequest.getContextPath()+"/PGViewAllServlet");
        }
        else {
            System.out.println("Failed & (" + statusUpdate + ") rows affected");
        }
    }

    public void getPgsInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PGModel> pgsList = null;
        PGModel pgData = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ResultSetMetaData rsmd = null;
        try {
            DataSource ds = new DataSource();
            connection = ds.getConnection();
            ps = connection.prepareStatement("select * from pg", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                pgsList = new ArrayList<PGModel>();
                resultSet.previous();
            }
            while (resultSet.next()) {
                pgData = new PGModel();
                pgData.setPgId(resultSet.getInt(1));
                pgData.setName(resultSet.getString(2));
                pgData.setCity(resultSet.getString(3));
                pgData.setAddress(resultSet.getString(4));
                pgData.setType(resultSet.getString(5));
                pgData.setRating(resultSet.getFloat(6));
                pgData.setStatus(resultSet.getBoolean(7));

//                System.out.println("Rating from database: " + resultSet.getFloat(7));
                pgData.setImgUrl(resultSet.getString(8));
                pgsList.add(pgData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != ps)
                    ps.close();
                if (null != connection)
                    connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(pgsList.toString());
        System.out.println();
        // Set pgList as an attribute
        req.setAttribute("pgsList", pgsList);

        // Forward to the JSP to display the cards
        req.getRequestDispatcher("/pages/pgViewAll.jsp").forward(req, resp);

    }
}
