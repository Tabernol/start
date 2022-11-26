package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User>{


    @Override
    public List<User> getAll() {
        String sql = "select * from user;";
        List<User> users;
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            users = new ArrayList<>();
            User user;
            while (resultSet.next()){
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

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
