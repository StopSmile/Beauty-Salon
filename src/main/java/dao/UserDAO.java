package dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void addUser(User user) throws SQLException;
    public User getByLogin(String login) throws SQLException;
    void updateUser(User user);
    void deleteUser(User user);
    List<User> getAll();

}
