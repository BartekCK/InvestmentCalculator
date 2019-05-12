package calculator.currency;

import calculator.currency.manage.ManageCurrency;
import calculator.currency.manage.Money;
import calculator.database.BaseModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;




@DatabaseTable(tableName = "B_AND_K_MONEY")
public class BandK extends Money implements ManageCurrency, BaseModel {


    @DatabaseField(columnName = "MONEY_RATE", canBeNull = false)
    static private double moneyRate;


    public BandK() {
        currencyName = "BandK";
        currencyShort = "BK";
    }

    @Override
    public void changeRate() {

    }

    @Override
    public double returnCurrentValue() {
        return moneyRate;
    }

}
