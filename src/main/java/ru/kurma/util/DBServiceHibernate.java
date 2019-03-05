package ru.kurma.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.kurma.model.User;

public class DBServiceHibernate {

    Configuration configuration = new Configuration();


    private Configuration createConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/users");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "041014");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hdm2dll.auto", "create");
        configuration.addAnnotatedClass(User.class);
        return configuration;
    }

    private SessionFactory createSF(Configuration configuration) {

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(this.configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();

        return configuration.buildSessionFactory(serviceRegistry);
    }





}
