package ru.kurma.service;

import ru.kurma.dao.UserDao;
import ru.kurma.model.User;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDao userDao;

    public UserService(final UserDao userDao) {
        this.userDao = userDao;
    }

    public void createNewUser(final String firsName, final String lastName) {
        userDao.createNewUser(firsName, lastName);
    }

    public User findUserById(final Integer id) {
        return userDao.findUserById(id);
    }

    public List<User> findAllUsers() {
        try {
            return userDao.findAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateUser(final Integer id, final String firstName, final String lastName) {
        userDao.updateUser(id, firstName, lastName);
    }

    public void deleteUser(final Integer id) {
        userDao.deleteUser(id);
    }
}
