package org.virtusa.zenstays.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.virtusa.zenstays.model.PGModel;
import org.virtusa.zenstays.model.RoomModel;
import org.virtusa.zenstays.utility.DataSource;

public class PGRoomDAO {
    // Method to fetch PG information by ID
    private PGModel fetchPGById(int pg_id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        PGModel pg = null;

        try {
            connection = DataSource.getConnection();
            String query = "SELECT * FROM PG WHERE pg_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, pg_id);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String city = rs.getString("city");
                String location = rs.getString("address");
                float rating = rs.getFloat("rating");
                pg = new PGModel(pg_id, name, city, location, rating);
            }
        } finally {
            // Close resources in a finally block to release database connections
            try {
                if (rs != null) rs.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pg;
    }
    private List<String> getFacilities(int pg_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> facilities = new ArrayList<>();

        try {
            connection = DataSource.getConnection();
            String query = "select f.name from facilities f join pg_facility p on f.facility_id = p.facility_id where p.pg_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, pg_id);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                facilities.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return facilities;
    }

    public List<RoomModel> readRooms() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<RoomModel> roomList = new ArrayList<>();

        try {
            connection = DataSource.getConnection();
            String query = "SELECT * FROM ROOM";
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int room_id = rs.getInt(1);
                boolean availability = rs.getBoolean(2);
                int pg_id = rs.getInt(3);
                int type = rs.getInt(4);

                // Fetch PG information from the database instead of using a HashMap
                PGModel pg = fetchPGById(pg_id);
//                pg.setFacilities(getFacilities(pg_id));

                roomList.add(new RoomModel(room_id, type, availability, pg));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close resources in a finally block to release database connections
            try {
                if (rs != null) rs.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return roomList;
    }

    public List<RoomModel> findRoomsBasedOn(float rating) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<RoomModel> filterRoomList = new ArrayList<>();

        try {
            connection = DataSource.getConnection();
            String query = "select r.* from room r inner join pg p on r.pg_id = p.pg_id where (rating >= ? && rating < ?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setFloat(1, rating);
            preparedStatement.setFloat(2, rating+1);


            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int room_id = resultSet.getInt(1);
                int type = resultSet.getInt(4);
                boolean availability = resultSet.getBoolean(2);
                int pg_id = resultSet.getInt(3);
                System.out.println(pg_id);

                PGModel pg = fetchPGById(pg_id);
//                pg.setFacilities(getFacilities(pg_id));

                filterRoomList.add(new RoomModel(room_id, type, availability, pg));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return filterRoomList;
    }
}
