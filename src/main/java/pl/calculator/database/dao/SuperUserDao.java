package pl.calculator.database.dao;

import pl.calculator.exceptions.CalculatorException;
import pl.calculator.models.model.SuperUser;
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
        return dao.queryForFirst(dao.queryBuilder().where().eq("EMAIL", email).prepare()) != null;

    }

}
