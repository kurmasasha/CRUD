package ru.kurma.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.kurma.model.User;
import ru.kurma.util.DBServiceHibernate;

import java.util.List;

public class UserDaoImplHibernate implements UserDao {

    private SessionFactory sessionFactory = DBServiceHibernate.createSF();

    @Override
    public List<User> findAllUsers() {
        Session session = sessionFactory.openSession();
        return session.createQuery("From User").list();
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
