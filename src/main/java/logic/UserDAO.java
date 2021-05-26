package logic;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UserDAO {
    private static Connection connection;
    private static UserDAO dbManager;
    private static final String SQLInset = "insert into users (firstName,lastName,login,password,email) values (?,?,?,?,?);";

    private UserDAO() throws SQLException, IOException {
        connection = getConnection();
    }

    public static UserDAO getInstance() throws SQLException, IOException {
        if (dbManager == null) dbManager = new UserDAO();
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

    public void InsertUser(BootsTrapUser user) throws SQLException {
        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement(SQLInset);
            pstm.setString(1, user.getFirstName());
            pstm.setString(2, user.getLastName());
            pstm.setString(3, user.getLogin());
            pstm.setString(4, user.getPassword());
            pstm.setString(5, user.getEmail());
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            assert pstm != null;
            pstm.close();
        }


    }
}
