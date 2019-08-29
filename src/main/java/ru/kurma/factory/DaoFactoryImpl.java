package ru.kurma.factory;

import ru.kurma.dao.UserDao;
import ru.kurma.dao.UserDaoImplHibernate;
import ru.kurma.dao.UserDaoImplJDBC;
import ru.kurma.util.ReadPropertyDao;

public class DaoFactoryImpl implements DaoFactory {

    public UserDao getUsedDao() {

        ReadPropertyDao readPropertyDao = new ReadPropertyDao();

        switch (readPropertyDao.getProperty()) {
            case ("JDBC"):
                return new UserDaoImplJDBC();
            case ("Hibernate"):
                return new UserDaoImplHibernate();
            default:
                return new UserDaoImplJDBC();
        }
    }
}
