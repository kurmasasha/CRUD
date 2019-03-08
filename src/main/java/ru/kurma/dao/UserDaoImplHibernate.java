package ru.kurma.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.kurma.model.User;
import ru.kurma.util.DBServiceHibernate;

import java.util.List;

public class UserDaoImplHibernate implements UserDao {

    private SessionFactory sessionFactory = DBServiceHibernate.createSF();

    @Override
    public List<User> findAllUsers() {
        List<User> users;
        Session session = sessionFactory.openSession();
        users = session.createQuery("From User").list();
        session.close();

        return users;
    }

    @Override
    public User findUserById(Integer id) {
        return null;
    }

    @Override
    public void createNewUser(String firstName, String lastName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new User(firstName, lastName));
        transaction.commit();
        session.close();

    }

    @Override
    public void updateUser(Integer id, String firstName, String lastName) {

    }

    @Override
    public void deleteUser(Integer id) {

    }
}
