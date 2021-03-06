package pl.calculator.database.dao;

import pl.calculator.currency.manage.CryptoCurrency;
import pl.calculator.exceptions.CalculatorException;
import pl.calculator.utilies.converters.DateConverter;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class CurrencyDao extends MainDao{
    public CurrencyDao() {
        super();
    }

    public <T extends CryptoCurrency> T pullLastCaTandBandK(Class<T> tClass, LocalDate localDate) throws CalculatorException, SQLException {

        Dao<T,Object> dao = getDao(tClass);
        Date date = DateConverter.convertToDate(localDate);
        PreparedQuery<T> temp = dao.queryBuilder().where().eq("VALID_FROM",date).prepare();
        return dao.queryForFirst(temp);
    }
    public <T extends CryptoCurrency> boolean isDateTableExist(Class<T> tClass) throws CalculatorException, SQLException {
        Dao<T,Object> dao = getDao(tClass);
        long temp = dao.queryBuilder().countOf();
        return temp > 0;
    }


}
