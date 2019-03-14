package ru.kurma.dao;

import ru.kurma.model.User;
import ru.kurma.util.DataBasesConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplJDBC implements UserDao{

    DataBasesConnector dataBasesConnector = DataBasesConnector.getInstance();

    private Connection connection = dataBasesConnector.getConnection();

    @Override
    public User findUserById(Integer id) {

        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM postgres.public.users WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = complitUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findUserByLogin(String login) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM postgres.public.users WHERE login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = complitUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery("SELECT * FROM postgres.public.users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {
                User user = complitUser(resultSet);
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void createNewUser(String firstName, String lastName, String login, String password, String role) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT  INTO " + "postgres.public.users(firstname, lastname, login, password, role) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, role);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(User user) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE postgres.public.users SET " +
                    "firstName = ?, lastname = ? WHERE id = ?");
                    preparedStatement.setString(1, user.getFirstName());
                    preparedStatement.setString(2, user.getLastName());
                    preparedStatement.setInt(3, user.getId());
                    preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM postgres.public.users WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User complitUser(ResultSet resultSet) {
        User user = null;
        try {
            Integer id = resultSet.getInt("id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            user = new User(firstName, lastName, login, password, role);
            user.setId(id);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
