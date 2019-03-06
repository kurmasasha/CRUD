package ru.kurma.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.kurma.model.User;

public class DBServiceHibernate {

    private static Configuration configuration = createConfiguration();


    private static Configuration createConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "041014");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hdm2dll.auto", "update");
        //configuration.setProperty("hibernate.default_schema", "test");
        configuration.addAnnotatedClass(User.class);
        return configuration;
    }

    public static SessionFactory createSF() {

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();

        return configuration.buildSessionFactory(serviceRegistry);
    }





}
