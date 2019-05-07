package calculator.database.tasks;

import calculator.database.dao.UserDao;
import calculator.exceptions.CalculatorException;
import calculator.user.User;

import java.sql.SQLException;

public class UserTask {

    public void addUserToDataBase(User user)
    {
        UserDao userDao = new UserDao();
        try {
            userDao.creatOrUpdate(user);
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }

    public User pullUserFromDataBase(String email,String password)
    {
        UserDao userDao = new UserDao();
        try {
            User user = userDao.findUserByRequiredProperty(email,password);
            return user;
        } catch (CalculatorException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
