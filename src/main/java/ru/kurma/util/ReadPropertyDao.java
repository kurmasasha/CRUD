package ru.kurma.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyDao {

    private Properties properties = new Properties();

    public String getPropierty() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("UserDAO.properties")){
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("userdao");
    }
}
