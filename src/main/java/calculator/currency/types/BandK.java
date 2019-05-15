package calculator.currency.types;

import calculator.currency.manage.CryptoCurrency;
import calculator.currency.manage.ManageCurrency;
import calculator.currency.manage.Money;
import calculator.database.BaseModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Random;


@DatabaseTable(tableName = "B_AND_K_MONEY")
public class BandK extends CryptoCurrency implements ManageCurrency, BaseModel {


    @DatabaseField(columnName = "MONEY_RATE", canBeNull = false)
    static private double moneyRate;


    public BandK() {
        currencyName = "BandK";
        currencyShort = "BK";
    }

    @Override
    public void changeRate() {
        Random random = new Random();
        moneyRate = random.nextDouble() * 10 - (5-(5*(this.polishMoney/100000)));
    }

    @Override
    public double returnCurrentValue() {
        return moneyRate;
    }

}
