package org.virtusa.zenstays.dao;

import org.virtusa.zenstays.model.RoomModel;
import org.virtusa.zenstays.utility.DataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnerRoomDAO {
    public void addingRooms(boolean availability, int pgId, int noOfBeds, HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {
        Connection con = null;
        PreparedStatement st = null;
        int statusUpdate = 0;

        try {
            DataSource ds = new DataSource();
            con = ds.getConnection();

            st = con.prepareStatement("insert into room (availability, pg_id, no_of_beds) values (?,?,?)");
            st.setBoolean(1, availability);
            st.setInt(2, pgId);
            st.setInt(3, noOfBeds);
            statusUpdate = st.executeUpdate();
        }catch(SQLException e1) {
            e1.printStackTrace();
        }
        if(statusUpdate != 0) {
            System.out.println("Success & ("+statusUpdate+") rows affected");
            servletResponse.sendRedirect(servletRequest.getContextPath()+"/RoomViewAllServlet");
        }
        else {
            System.out.println("Failed & (" + statusUpdate + ") rows affected");
        }
    }

    public void getRoomsInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoomModel> roomList = null;
        RoomModel roomData = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            DataSource ds = new DataSource();
            connection = ds.getConnection();
            ps = connection.prepareStatement("select * from room", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                roomList = new ArrayList<RoomModel>();
                resultSet.previous();
            }
            while (resultSet.next()) {
                roomData = new RoomModel();
                roomData.setRoomId(resultSet.getInt(1));
                roomData.setAvailability(resultSet.getBoolean(2));
                roomData.setPgId(resultSet.getInt(3));
                roomData.setNoOfBeds(resultSet.getInt(4));
                roomList.add(roomData);
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
        System.out.println(roomList.toString());

        req.setAttribute("roomList", roomList);

        // Forward to the JSP to display the cards
        req.getRequestDispatcher("/pages/roomViewAll.jsp").forward(req, resp);

    }
}

