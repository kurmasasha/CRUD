package ru.kurma.service;

import ru.kurma.dao.*;
import ru.kurma.model.User;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class UserService {

    private String separator = File.separator;

    private String path = "src" + separator + "main" + separator + "resources" + separator + "UserDAO.properties";

    private static UserService instance;

    private UserDaoFactory factory = createUserDaoFactory();

    private UserDao userDao = factory.getUsedDao();

    private

    FileInputStream fileInputStream;

    private UserService() {

    }

    private UserDaoFactory createUserDaoFactory() {

        String daoProperties = "";

        Properties properties = new Properties();

        File file = new File(path);
        file.getParentFile().mkdirs();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write(456);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileInputStream fileInputStream = new FileInputStream(path)){
            properties.load(fileInputStream);
            daoProperties = properties.getProperty("UserDao");
        }  catch (IOException e) {
            e.printStackTrace();
        }

        switch (daoProperties) {
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
