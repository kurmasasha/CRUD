package ru.kurma.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.kurma.model.User;
import ru.kurma.util.DBServiceHibernate;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImplHibernate implements UserDao {

    private SessionFactory sessionFactory = DBServiceHibernate.createSF();

    @Override
    public List<User> findAllUsers() throws SQLException {
        Session session = sessionFactory.openSession();
        //session.createQuery("from users").list().forEach(System.out::println);
        //List<User> list = (List<User>) query.list();

        return session.createQuery("From User", User.class).list();
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
