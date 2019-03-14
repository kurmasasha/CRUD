package ru.kurma.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import ru.kurma.model.User;
import ru.kurma.util.DataBasesConnector;
import java.util.List;

public class UserDaoImplHibernate implements UserDao {

    private DataBasesConnector dataBasesConnector = DataBasesConnector.getInstance();
    private Configuration configuration = dataBasesConnector.getConfiguration();
    private SessionFactory sessionFactory = createSF();

    private SessionFactory createSF() {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }


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
        User user;
        Session session = sessionFactory.openSession();
        user = session.get(User.class, id);
        session.close();
        return user;
    }


    @Override
    public User findUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From User where login = :login");
        query.setParameter("login", login);
        List<User> list = query.list();
        if (list.size() == 0) {
            return null;
        }
        else return list.get(0);
    }

    @Override
    public void createNewUser(String firstName, String lastName, String login, String password, String role){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new User(firstName, lastName, login, password, role));
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(Integer id) {
        User user = findUserById(id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
