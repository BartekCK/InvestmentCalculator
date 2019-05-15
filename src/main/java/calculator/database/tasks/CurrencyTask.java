package calculator.database.tasks;

import calculator.currency.manage.CryptoCurrency;
import calculator.currency.manage.ManageCurrency;
import calculator.database.dao.CurrencyDao;
import calculator.exceptions.CalculatorException;


import java.sql.SQLException;
import java.time.LocalDate;

public class CurrencyTask {

    public void addCurrencyToDataBase(ManageCurrency manageCurrency)
    {
        CurrencyDao currencyDao = new CurrencyDao();
        try {
            currencyDao.creatOrUpdate(manageCurrency);
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }

    public double getPolishMoneyFromLast(ManageCurrency currency, LocalDate localDate) {
        CurrencyDao currencyDao = new CurrencyDao();

        try {
            if(currencyDao.isDateTableExist(currency.getClass()))
            {
                ManageCurrency asd = currencyDao.pullLastCaTandBandK(currency.getClass(), localDate);
                return ((CryptoCurrency)asd).getPolishMoney();
            }
        } catch (CalculatorException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
