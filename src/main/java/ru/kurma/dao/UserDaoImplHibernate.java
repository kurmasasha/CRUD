package ru.kurma.dao;

import org.hibernate.SessionFactory;
import ru.kurma.model.User;
import ru.kurma.util.DBServiceHibernate;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImplHibernate implements UserDao {

    private SessionFactory sessionFactory = DBServiceHibernate.createSF();

    @Override
    public List<User> findAllUsers() throws SQLException {
        //List<User> users =
        return null;
    }

    @Override
    public User findUserById(Integer id) {
        return null;
    }

    @Override
    public void createNewUser(String firstName, String lastName) {

    }

    @Override
    public void updateUser(Integer id, String firstName, String lastName) {

    }

    @Override
    public void deleteUser(Integer id) {

    }
}
