package ru.kurma.dao;

import org.hibernate.internal.ExceptionMapperStandardImpl;
import org.postgresql.util.PSQLException;
import ru.kurma.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> findAllUsers() throws SQLException;
    User findUserById(Integer id);
    User findUserByLogin(String login);
    void createNewUser(String firstName, String lastName, String login, String password, String role) throws Exception;
    void updateUser(Integer id, User user);
    void deleteUser(Integer id);

}
