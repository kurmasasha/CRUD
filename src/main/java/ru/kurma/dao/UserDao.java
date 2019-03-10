package ru.kurma.dao;

import ru.kurma.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> findAllUsers() throws SQLException;
    User findUserById(Integer id);
    User findUserByLogin(String login);
    void createNewUser(String firstName, String lastName, String password);
    void updateUser(Integer id, User user);
    void deleteUser(Integer id);

}
