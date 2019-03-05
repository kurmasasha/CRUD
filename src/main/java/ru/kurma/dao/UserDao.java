package ru.kurma.dao;

import ru.kurma.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> findAll() throws SQLException;
    User find(int id);
    void create(String firstName, String lastName);
    void update(int id, String firstName, String lastName);
    void delete(int id);

}
