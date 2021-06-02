package service;

import db.DBConnect;
import entity.TimeSlot;
import entity.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TimeSlotService extends DBConnect {
    Connection connection = getConnection();
    private static final String SELECT_TIME_SLOTS = "select * from timeslots";

    public ArrayList<TimeSlot> getTimeSlots() throws SQLException, IOException {
        ArrayList<TimeSlot> list = new ArrayList<>();
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.createStatement();
            rs = stm.executeQuery(SELECT_TIME_SLOTS);
            while (rs.next()) {
                TimeSlot timeSlot = new TimeSlot();
                timeSlot.setId(rs.getInt("id"));
                timeSlot.setTimeStart(rs.getTime("timestart"));
                timeSlot.setTimeEnd(rs.getTime("timeend"));
                list.add(timeSlot);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert stm != null;
            stm.close();
            assert rs != null;
            rs.close();
        }
        return list;
    }
}
