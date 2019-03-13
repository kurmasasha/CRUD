package ru.kurma.util;


import org.hibernate.cfg.Configuration;
import org.postgresql.Driver;
import ru.kurma.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBasesConnector {

    private static DataBasesConnector instance;

    private DataBasesConnector() {
    }


    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String user = "postgres";
    private String password = "123456";
    private String className = "org.postgresql.Driver";

    public static DataBasesConnector getInstance() {
        if (instance == null) {
            instance =  new DataBasesConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName(className).newInstance());
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/testdb");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "123456");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        //configuration.setProperty("hibernate.default_schema", "test");
        configuration.addAnnotatedClass(User.class);
        return configuration;
    }
}
