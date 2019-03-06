package ru.kurma.service;

import ru.kurma.dao.UserDao;
import ru.kurma.dao.UserDaoImplHibernate;
import ru.kurma.dao.UserDaoImplJDBC;
import ru.kurma.model.User;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    //private static UserDao userDao = new UserDaoImplJDBC();
    private static UserDao userDao = new UserDaoImplHibernate();


    public static void createNewUser(String firsName, String lastName) {
        userDao.createNewUser(firsName, lastName);
    }

    public static User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    public static List<User> findAllUsers() {
        try {
            return userDao.findAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void updateUser(Integer id, String firtName, String lastName) {
        userDao.updateUser(id, firtName, lastName);
    }

    public static void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
