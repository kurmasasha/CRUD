package ru.kurma.service;

import ru.kurma.dao.UserDao;
import ru.kurma.factory.DaoFactoryImpl;
import ru.kurma.model.User;
import java.sql.SQLException;
import java.util.List;


public class UserService {

    private static UserService instance;


    private UserDao userDao = new DaoFactoryImpl().getUsedDao();


    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance =  new UserService();
        }
        return instance;
    }

    public void createNewUser(String firsName, String lastName, String login, String password, String role) throws Exception {
        userDao.createNewUser(firsName, lastName, login, password, role);
    }

    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    public User findUserByLogin(String login) {
        return userDao.findUserByLogin(login);

    }

    public List<User> findAllUsers() {
        try {
            return userDao.findAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
