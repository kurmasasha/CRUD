package ru.kurma.util;


import org.postgresql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBServiceJDBC {

    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "041014";
    private static String className = "org.postgresql.Driver";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName(className).newInstance());
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
