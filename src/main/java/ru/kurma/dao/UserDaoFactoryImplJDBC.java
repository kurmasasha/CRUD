package ru.kurma.dao;

public class UserDaoFactoryImplJDBC implements UserDaoFactory {
    @Override
    public UserDao getUsedDao() {
        return new UserDaoImplJDBC();
    }
}
