package ru.kurma.dao;

import ru.kurma.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> findAllUsers() throws SQLException;
    User findUserById(Integer id);
    void createNewUser(String firstName, String lastName);
    void updateUser(Integer id, String firstName, String lastName);
    void deleteUser(Integer id);

}
