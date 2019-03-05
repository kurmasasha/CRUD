package ru.kurma.service;


import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {

    private static String url = "jdbc:postgresql://localhost:5432/testdb";
    private static String user = "postgres";
    private static String password = "041014";
    private static String className = "org.postgresql.Driver";

    public static Connection getConnection() throws SQLException {
        try {
            DriverManager.registerDriver((Driver) Class.forName(className).newInstance());
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(url, user, password);
    }
}
