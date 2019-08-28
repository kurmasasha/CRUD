package ru.kurma.factory;

import ru.kurma.dao.UserDao;

public interface DaoFactory {

    UserDao getUsedDao();
}
