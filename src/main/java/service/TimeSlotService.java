package service;

import db.DBConnect;
import entity.TimeSlot;
import entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class TimeSlotService extends DBConnect {
    Connection connection = getConnection();
    private static final String SELECT_TIME_SLOTS = "select * from timeslots";
    private static final String SELECT_TIME_SLOTS_FOR_MASTER = "SELECT * FROM timeslots ts where ts.id not in(select timeslotid from public.order where masterid=? and date=? AND orderstatusid=1)";

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

    public ArrayList<TimeSlot> getTimeSlotsForMaster(int masterid, Date date) throws SQLException {
        ArrayList<TimeSlot> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(SELECT_TIME_SLOTS_FOR_MASTER);
            ps.setInt(1, masterid);
            ps.setDate(2, date);
            rs = ps.executeQuery();
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
            assert ps != null;
            ps.close();
            assert rs != null;
            rs.close();
        }
        return list;
    }
}
