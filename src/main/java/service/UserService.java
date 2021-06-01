package service;

import db.DBConnect;
import entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class UserService extends DBConnect implements dao.UserDAO {

    private static final String INSERT = "insert into users (id,firstname,lastname,login,password,email,roleid,servicegroupid,rating) values (DEFAULT,?,?,?,?,?,?,?,?);";
    private static final String SELECT_USER = "select * from users where login=?";
    private static final String SELECT_EMAIL = "select * from users where email=?";
    private static final String SELECT_MASTER_BY_NAME = "select * from users where firstname=?";
    private static final String SQLSelectMasters = "select * from users where roleid = 4";
    private static final String SELECT_MASTERS_BY_NAME_UP = "select * from users where roleid = 4 order by firstname";
    private static final String SELECT_MASTERS_BY_NAME_DOWN = "select * from users where roleid=4 order by firstname DESC";
    private static final String SELECT_MASTERS_BY_RATE_DOWN = "select * from users where roleid = 4 order by rating";
    private static final String SELECT_MASTERS_BY_RATE_UP = "select * from users where roleid = 4 order by rating DESC";

    Connection connection = getConnection();

    @Override
    public void addUser(User user) throws SQLException {
        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement(INSERT);
            pstm.setString(1, user.getFirstName());
            pstm.setString(2, user.getLastName());
            pstm.setString(3, user.getLogin());
            pstm.setString(4, user.getPassword());
            pstm.setString(5, user.getEmail());
            pstm.setInt(6, user.getRoleId());
            pstm.setInt(7, user.getServiceGroupId());
            pstm.setInt(8, user.getRating());

            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert pstm != null;
            pstm.close();

        }
    }

    @Override
    public User getByLogin(String login) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            ps = connection.prepareStatement(SELECT_USER);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setLogin(rs.getString("login"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getInt("roleid"));
                user.setId(rs.getInt("id"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert ps != null;
            ps.close();
            assert rs != null;
            rs.close();

        }
        return user;
    }

    public String checkLogin(String login) throws SQLException {
        String result = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_USER);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString("login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
        }
        return result;
    }

    public String checkEmail(String login) throws SQLException {
        String result = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_EMAIL);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
        }
        return result;
    }

    public ArrayList<User> getMasters() throws SQLException, IOException {
        ArrayList<User> list = new ArrayList<>();
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.createStatement();
            rs = stm.executeQuery(SQLSelectMasters);
            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setLogin(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setRoleId(rs.getInt(7));
                user.setRating(rs.getInt(8));
                list.add(user);
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

    public ArrayList<User> getSortedMastersByNameUp() throws SQLException, IOException {
        ArrayList<User> list = new ArrayList<>();
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.createStatement();
            rs = stm.executeQuery(SELECT_MASTERS_BY_NAME_UP);
            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setLogin(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setRoleId(rs.getInt(7));
                user.setRating(rs.getInt(8));
                list.add(user);
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

    public ArrayList<User> getSortedMastersByNameDown() throws SQLException, IOException {
        ArrayList<User> list = new ArrayList<>();
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.createStatement();
            rs = stm.executeQuery(SELECT_MASTERS_BY_NAME_DOWN);
            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setLogin(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setRoleId(rs.getInt(7));
                user.setRating(rs.getInt(8));
                list.add(user);
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

    public ArrayList<User> getSortedMastersByRatingUp() throws SQLException, IOException {
        ArrayList<User> list = new ArrayList<>();
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.createStatement();
            rs = stm.executeQuery(SELECT_MASTERS_BY_RATE_UP);
            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setLogin(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setRoleId(rs.getInt(7));
                user.setRating(rs.getInt(8));
                list.add(user);
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

    public ArrayList<User> getSortedMastersByRatingDown() throws SQLException, IOException {
        ArrayList<User> list = new ArrayList<>();
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.createStatement();
            rs = stm.executeQuery(SELECT_MASTERS_BY_RATE_DOWN);
            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setLogin(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setRoleId(rs.getInt(7));
                user.setRating(rs.getInt(8));
                list.add(user);
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
    public ArrayList<User> getMaster(String name) throws SQLException, IOException {
        ArrayList<User> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(SELECT_MASTER_BY_NAME);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setRating(rs.getInt("rating"));
                list.add(user);
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
    public ArrayList<User> getMasterInfo(String name) throws SQLException, IOException {
        ArrayList<User> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(SELECT_MASTER_BY_NAME);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setRating(rs.getInt("rating"));
                list.add(user);
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

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
