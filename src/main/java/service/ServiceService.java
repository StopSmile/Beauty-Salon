package service;

import db.DBConnect;
import entity.Service;
import entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ServiceService extends DBConnect {
    Connection connection = getConnection();
    private static final String SELECT_ALL_SERVICES = "SELECT * FROM services";
    private static final String MASTER_FILTER = "select * from users u , services s  where firstname = ? and u.servicegroupid = s.servicegroupidd";

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
    public ArrayList<Service> getMasterInfo(String name) throws SQLException, IOException {
        ArrayList<Service> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(MASTER_FILTER);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                Service service = new Service();
                service.setName(rs.getString("name"));
                service.setPrice(rs.getDouble("price"));
                service.setId(rs.getInt("id"));
                service.setServiceGroupId(rs.getInt("servicegroupidd"));
                list.add(service);
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
