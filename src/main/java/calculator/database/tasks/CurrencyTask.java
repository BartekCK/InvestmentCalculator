package calculator.database.tasks;

import calculator.currency.manage.CryptoCurrency;

import calculator.currency.manage.Money;
import calculator.models.modelFx.CryptoCurrencyFx;
import calculator.database.dao.CurrencyDao;
import calculator.exceptions.CalculatorException;
import calculator.utilies.converters.CryptoCurrencyConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CurrencyTask {

    public void addCurrencyToDataBase(CryptoCurrency cryptoCurrency)
    {
        CurrencyDao currencyDao = new CurrencyDao();
        try {
            currencyDao.creatOrUpdate(cryptoCurrency);
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }

    public double getPolishMoneyFromLast(CryptoCurrency cryptoCurrency, LocalDate localDate) {
        CurrencyDao currencyDao = new CurrencyDao();

        try {
            if(currencyDao.isDateTableExist(cryptoCurrency.getClass()))
            {
                return currencyDao.pullLastCaTandBandK(cryptoCurrency.getClass(), localDate).getPolishMoney();
            }
        } catch (CalculatorException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Money getLastCurrency(CryptoCurrency cryptoCurrency)
    {
        CurrencyDao currencyDao = new CurrencyDao();
        try {
            if(currencyDao.isDateTableExist(cryptoCurrency.getClass()))
            {
                return (Money) currencyDao.pullLastCaTandBandK(cryptoCurrency.getClass(),LocalDate.now());
            }
        } catch (CalculatorException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public ObservableList<Money> init(ObservableList<Money> list)
    {

        ObservableList<Money> temp = FXCollections.observableArrayList();
        list.forEach(money -> {
            if(money instanceof CryptoCurrency)
            {
                money = getLastCurrency((CryptoCurrency) money);
            }
            temp.add(money);
        });
        return temp;
   }

   public ObservableList<CryptoCurrencyFx> pushAllCurrencies(CryptoCurrency cryptoCurrency)
   {

       try {
           CurrencyDao currencyDao = new CurrencyDao();
           List<? extends CryptoCurrency> temp1 = currencyDao.queryForAll(cryptoCurrency.getClass());
           ObservableList<CryptoCurrencyFx> temp2 = FXCollections.observableArrayList();
           temp1.forEach(cryptoCurrency1->{
               temp2.add( CryptoCurrencyConverter.convertToCryptoCurrencyFx(cryptoCurrency1));
           });

           return temp2;

       } catch (CalculatorException e) {
           e.printStackTrace();
       }

       return null;
   }



}




