package ru.kurma.dao;

public class UserDaoFactoryImplHibernate implements UserDaoFactory {
    @Override
    public UserDao getUsedDao() {
        return new UserDaoImplHibernate();
    }
}
