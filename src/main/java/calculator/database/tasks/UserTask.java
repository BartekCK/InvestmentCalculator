package calculator.database.tasks;

import calculator.database.dao.UserDao;
import calculator.exceptions.CalculatorException;
import calculator.user.User;

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
}
