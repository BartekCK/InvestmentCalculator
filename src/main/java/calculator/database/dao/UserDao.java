package calculator.database.dao;

import calculator.exceptions.CalculatorException;
import calculator.user.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;

public class UserDao extends MainDao {
    public UserDao() {
        super();
    }

    public User findUserByRequiredProperty(String email, String password) throws CalculatorException, SQLException {

        Dao<User,Object> dao = getDao(User.class);
        PreparedQuery<User> temp = dao.queryBuilder().where().eq("EMAIL", email).and().eq("PASSWORD", password).prepare();
        return dao.queryForFirst(temp);
    }

    public boolean checkFigureEmail(String email) throws SQLException, CalculatorException {

        Dao<User,Object> dao = getDao(User.class);
        if(dao.queryForFirst(dao.queryBuilder().where().eq("EMAIL", email).prepare()) == null)
            return false;
        else
            return true;

    }

}
