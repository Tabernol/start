package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {


    @Override
    public List<User> getAll() {
        String sql = "select * from user";
        List<User> users;
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            users = new ArrayList<>();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id_user"));
                user.setLogin(resultSet.getString("login_user"));
                user.setPassword(resultSet.getString("pass_user"));
                user.setName(resultSet.getString("name_user"));
                user.setRole(resultSet.getString("role_user"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isUserExist(String login) {
        String sql = "select * from user where login_user like ?";
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRoleByLogin(String login) {
        String sql = "select * from user where login_user like ?";
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            String roleUser = "unknown";
            if (resultSet.next()) {
                roleUser = resultSet.getString("role_user");
            }
            return roleUser;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User get(String login) {
        String sql = "select * from user where login_user like ?";
        User user = new User();
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, login);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id_user"));
                user.setLogin(resultSet.getString("login_user"));
                user.setPassword(resultSet.getString("pass_user"));
                user.setName(resultSet.getString("name_user"));
                user.setRole(resultSet.getString("role_user"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    public void createUser(String login, String password, String name) {
        String sql = "insert into user (id_user, login_user, pass_user, role_user, name_user) " +
                "values (default, ?, ?, ?, ?)";
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, password);
            pst.setString(3, "user");
            pst.setString(4, name);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public String getRoleByLoginPassword(final String login, final String password) {
//
//
//        return getRoleByLogin(login);
//    }

    public boolean isCorrectPassword(String login, String password) {
        String sql = "select * from user where login_user like ?";
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String passUser = resultSet.getString("pass_user");
            return password.equals(passUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}