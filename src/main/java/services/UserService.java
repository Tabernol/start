package services;

import dao.UserDao;
import model.User;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public boolean isUserExist(String login){
        return userDao.isUserExist(login);
    }
     public boolean isCorrectPassword(long id, String password){
        User user = userDao.get(id);
        return password.equals(user.getPassword());
     }

     public String getRoleById(long id){
        User user = userDao.get(id);
        return user.getRole();
     }

     public void deleteUser(String login){
        userDao.delete(login);
     }

     public User getUser(long id){
        return userDao.get(id);
     }

     public long getId(String login){
        return userDao.getId(login);
     }
}
