package ru.kurma.dao;

import ru.kurma.model.User;
import ru.kurma.service.DBService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public User find(int id) {

        User user = null;
        try {
            PreparedStatement preparedStatement = DBService.getConnection().prepareStatement("SELECT * FROM testdb.test.users WHERE id = ?");
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
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = DBService.getConnection().createStatement().executeQuery("SELECT * FROM testdb.test.users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

            while (true) {
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    Integer id = resultSet.getInt("id");
                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");
                    User user = new User(id, firstName, lastName, "");
                    users.add(user);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        return users;
    }

    @Override
    public void create(String firstName, String lastName) {
        try {
            PreparedStatement preparedStatement = DBService.getConnection().prepareStatement
                    ("INSERT  INTO " + "testdb.test.users(firstname, lastname) VALUES (?,?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            //preparedStatement.setString(3, password);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(int id, String firstName, String lastName) {

        User user = find(id);

        try {
            PreparedStatement preparedStatement = DBService.getConnection().prepareStatement("UPDATE testdb.test.users SET " +
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
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = DBService.getConnection().prepareStatement("DELETE FROM testdb.test.users WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
