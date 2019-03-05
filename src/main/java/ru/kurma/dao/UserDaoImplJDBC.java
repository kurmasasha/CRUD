package ru.kurma.dao;

import ru.kurma.model.User;
import ru.kurma.util.DBServiceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplJDBC implements UserDao{

    Connection connection = DBServiceJDBC.getConnection();

    @Override
    public User findUserById(Integer id) {

        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM testdb.test.users WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            user = new User(id, firstName, lastName, "");


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
            resultSet = connection.createStatement().executeQuery("SELECT * FROM testdb.test.users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                User user = new User(id, firstName, lastName, "");
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void createNewUser(String firstName, String lastName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT  INTO " + "testdb.test.users(firstname, lastname) VALUES (?,?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(Integer id, String firstName, String lastName) {

        User user = findUserById(id);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE testdb.test.users SET " +
                    "firstName = ?, lastname = ? WHERE id = ?");
                    preparedStatement.setString(1, firstName);
                    preparedStatement.setString(2, lastName);
                    preparedStatement.setInt(3, id);
                    preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM testdb.test.users WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
