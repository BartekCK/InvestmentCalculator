package calculator.database.dao;

import calculator.exceptions.CalculatorException;
import calculator.user.SuperUser;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;

public class SuperUserDao extends MainDao {
    public SuperUserDao() {
        super();
    }

    public SuperUser findUserByRequiredProperty(String email, String password) throws CalculatorException, SQLException {

        Dao<SuperUser,Object> dao = getDao(SuperUser.class);
        PreparedQuery<SuperUser> temp = dao.queryBuilder().where().eq("EMAIL", email).and().eq("PASSWORD", password).prepare();
        return dao.queryForFirst(temp);
    }

    public boolean checkFigureEmail(String email) throws SQLException, CalculatorException {

        Dao<SuperUser,Object> dao = getDao(SuperUser.class);
        if(dao.queryForFirst(dao.queryBuilder().where().eq("EMAIL", email).prepare()) == null)
            return false;
        else
            return true;

    }

}
