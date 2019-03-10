package ru.kurma.service;

import ru.kurma.dao.*;
import ru.kurma.model.User;
import ru.kurma.util.ReadPropertyDao;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class UserService {



    private static UserService instance;

    private UserDaoFactory factory = createUserDaoFactory();

    private UserDao userDao = factory.getUsedDao();

    private UserService() {

    }

    private UserDaoFactory createUserDaoFactory() {

        ReadPropertyDao readPropertyDao = new ReadPropertyDao();

        switch (readPropertyDao.getPropierty()) {
            case ("JDBC"):
                return new UserDaoFactoryImplJDBC();
            case ("Hibernate"):
                return new UserDaoFactoryImplHibernate();
                default:
                    return new UserDaoFactoryImplJDBC();
        }
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance =  new UserService();
        }
        return instance;
    }

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

    public void updateUser(Integer id, String firstName, String lastName) {
        userDao.updateUser(id, firstName, lastName);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
