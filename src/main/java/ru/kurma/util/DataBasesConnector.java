package ru.kurma.util;


import org.hibernate.cfg.Configuration;
import org.postgresql.Driver;
import ru.kurma.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBasesConnector {

    private static DataBasesConnector instance;

    private final String URL = "jdbc:postgresql://localhost:5432/testdb";
    private final String USER = "postgres";
    private final String PASSWORD = "041014";
    private final String CLASSNAME = "org.postgresql.Driver";

    private DataBasesConnector() {
    }

    public static DataBasesConnector getInstance() {
        if (instance == null) {
            instance =  new DataBasesConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName(CLASSNAME).newInstance());
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.connection.driver_class", CLASSNAME);
        configuration.setProperty("hibernate.connection.url", URL);
        configuration.setProperty("hibernate.connection.username", USER);
        configuration.setProperty("hibernate.connection.password", PASSWORD);
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.addAnnotatedClass(User.class);
        return configuration;
    }
}
