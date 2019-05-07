package calculator.database.dao;

import calculator.exceptions.CalculatorException;
import calculator.user.SuperUser;
import calculator.date.Transaction;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import java.sql.SQLException;
import java.util.List;

public class TransactionDao extends MainDao {
    public TransactionDao() {
        super();
    }

    public List pushTransactionByUserId(SuperUser superUser) throws SQLException, CalculatorException {

        Dao<Transaction,Object> dao = getDao(Transaction.class);
        PreparedQuery<Transaction> temp = dao.queryBuilder().where().eq("SUPER_USER_ID", superUser.getId()).prepare();
        return dao.query(temp);
    }
}
