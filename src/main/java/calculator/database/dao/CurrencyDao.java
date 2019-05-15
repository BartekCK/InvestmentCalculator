package calculator.database.dao;

import calculator.currency.manage.ManageCurrency;
import calculator.exceptions.CalculatorException;
import calculator.utilies.converters.ConvertToDate;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class CurrencyDao extends MainDao{
    public CurrencyDao() {
        super();
    }


    public <T extends ManageCurrency> T pullLastCaTandBandK(Class<T> tClass,LocalDate localDate) throws CalculatorException, SQLException {

        Dao<T,Object> dao = getDao(tClass);
        Date date = ConvertToDate.convertToDate(localDate);
        PreparedQuery<T> temp = dao.queryBuilder().where().eq("VALID_FROM",date).prepare();
        return dao.queryForFirst(temp);
    }
    public <T extends ManageCurrency> boolean isDateTableExist(Class<T> tClass) throws CalculatorException, SQLException {
        Dao<T,Object> dao = getDao(tClass);
        long temp = dao.queryBuilder().countOf();
        System.out.println(temp);
        return temp > 0;
    }



}
