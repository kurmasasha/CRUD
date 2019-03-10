package ru.kurma.service;

import ru.kurma.dao.*;
import ru.kurma.model.User;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class UserService {

    private String separator = File.separator;

    private String path = "." + separator + "src" + separator + "main" + separator + "resources" + separator + "UserDAO.properties";


    private static UserService instance;

    private UserDaoFactory factory = createUserDaoFactory();

    private UserDao userDao = factory.getUsedDao();

    private UserService() {

    }

    private UserDaoFactory createUserDaoFactory() {

//        try (FileOutputStream fileOutputStream = new FileOutputStream("123")){
//            fileOutputStream.write(3);
//            fileOutputStream.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        String daoProperties = null;

        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(path)){
            //properties.load(fis);
            properties.setProperty("userdao", "Hibernate");
            daoProperties = properties.getProperty("userdao");
            System.out.println(daoProperties);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();



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
