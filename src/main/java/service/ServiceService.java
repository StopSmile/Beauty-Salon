package service;

import db.DBConnect;
import entity.Service;
import entity.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceService extends DBConnect {
    Connection connection = getConnection();
    private static final String SELECT_ALL_SERVICES = "SELECT * FROM services";

    public ArrayList<Service> getServices() throws SQLException, IOException {
        ArrayList<Service> list = new ArrayList<>();
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.createStatement();
            rs = stm.executeQuery(SELECT_ALL_SERVICES);
            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt(1));
                service.setName(rs.getString(2));
                service.setServiceGroupId(rs.getInt(3));
                service.setPrice(rs.getDouble(4));
                list.add(service);
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
