package calculator.database.tasks;

import calculator.database.dao.SuperUserDao;
import calculator.exceptions.CalculatorException;
import calculator.user.SuperUser;

import java.sql.SQLException;

public class UserTask {

    public void addUserToDataBase(SuperUser superUser)
    {
        SuperUserDao superUserDao = new SuperUserDao();
        try {
            superUserDao.creatOrUpdate(superUser);
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }

    public SuperUser pullUserFromDataBase(String email, String password)
    {
        SuperUserDao superUserDao = new SuperUserDao();
        try {
            SuperUser superUser = superUserDao.findUserByRequiredProperty(email,password);
            return superUser;
        } catch (CalculatorException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
