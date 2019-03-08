package ru.kurma.service;

import ru.kurma.dao.UserDao;
import ru.kurma.dao.UserDaoImplHibernate;
import ru.kurma.dao.UserDaoImplJDBC;
import ru.kurma.model.User;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserService() {

    }

    public static UserService getInstance() {
        UserService userService = null;

        if (userService == null) {
            userService =  new UserService();
            return userService;
        }
        else return userService;
    }

    //private static UserDao userDao = new UserDaoImplJDBC();
    private UserDao userDao = new UserDaoImplHibernate();


    public void createNewUser(String firsName, String lastName) {
        userDao.createNewUser(firsName, lastName);
    }

    public User findUserById(Integer id) {
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

    public void updateUser(Integer id, String firtName, String lastName) {
        userDao.updateUser(id, firtName, lastName);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
