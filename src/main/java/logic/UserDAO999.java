package logic;


import entity.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class UserDAO999 {
    private static Connection connection;
    private static UserDAO999 dbManager;
    private static final String SQLInset = "insert into users (firstName,lastName,login,password,email,roleId,rating,serviceGroupId) values (?,?,?,?,?,?,?,?);";
    private static final String SQLSelectMasters = "select * from users where roleid = 4";
    private static final String INSERT = "INSERT INTO users (roleId,serviceGroupId,firstname,lastname,login,password,email,rating) VALUES (?,?,?,?,?,?,?,?);";

    private UserDAO999() throws SQLException, IOException {
        connection = getConnection();
    }

    public static UserDAO999 getInstance() throws SQLException, IOException {
        if (dbManager == null) dbManager = new UserDAO999();
        return dbManager;
    }

    public Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File("C:\\Users\\Admin\\Desktop\\BeautySalon\\src\\main\\resources\\app.properties");
        FileInputStream in = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(in);

        String url = properties.getProperty("connection.url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }

//    public void InsertUser(User user) throws SQLException {
//
//        PreparedStatement pstm = null;
//        try {
//            pstm = connection.prepareStatement(SQLInset);
//            pstm.setString(1, user.getFirstName());
//            pstm.setString(2, user.getLastName());
//            pstm.setString(3, user.getLogin());
//            pstm.setString(4, user.getPassword());
//            pstm.setString(5, user.getEmail());
//            pstm.setInt(6, user.getRoleId());
//            pstm.setInt(7,user.getRating());
//            pstm.setInt(8,user.getServiceGroupId());
//            pstm.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            assert pstm != null;
//            pstm.close();
//            connection.close();
//        }
//
//    }


//    public void addUser(User user) throws SQLException {
//        PreparedStatement pstm = null;
//        try {
//            pstm = connection.prepareStatement(INSERT);
//            pstm.setInt(1, user.getRoleId());
//            pstm.setInt(2, user.getServiceGroupId());
//            pstm.setString(3, user.getFirstName());
//            pstm.setString(4, user.getLastName());
//            pstm.setString(5, user.getLogin());
//            pstm.setString(6, user.getPassword());
//            pstm.setString(7, user.getEmail());
//            pstm.setInt(8, user.getRating());
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            assert pstm != null;
//            pstm.close();
//            connection.close();
//        }
//    }

//    public ArrayList<User> getMasters() throws SQLException, IOException {
//        ArrayList<User> list = new ArrayList<>();
//        Statement stm = null;
//        ResultSet rs = null;
//        try {
//            stm = connection.createStatement();
//            rs = stm.executeQuery(SQLSelectMasters);
//            while (rs.next()) {
//                User user = new User();
//                user.setFirstName(rs.getString(2));
//                user.setLastName(rs.getString(3));
//                user.setLogin(rs.getString(4));
//                user.setPassword(rs.getString(5));
//                user.setEmail(rs.getString(6));
//                user.setRoleId(rs.getInt(7));
//                user.setRating(rs.getInt(8));
//                list.add(user);
//            }
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            assert stm != null;
//            stm.close();
//            assert rs != null;
//            rs.close();
//        }
//
//
//        return list;
//    }

    public static void main(String[] args) throws SQLException, IOException {

    }

}
