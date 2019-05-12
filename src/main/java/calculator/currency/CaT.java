package calculator.currency;

import calculator.currency.manage.ManageCurrency;
import calculator.currency.manage.Money;
import calculator.database.BaseModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;



@DatabaseTable(tableName = "CAT_MONEY")
public class CaT extends Money implements ManageCurrency, BaseModel {

    @DatabaseField(columnName = "MONEY_RATE", canBeNull = false)
    static private double moneyRate;

    public CaT() {
        currencyName = "CaT";
        currencyShort = "CT";
    }

    @Override
    public void changeRate() {

    }

    @Override
    public double returnCurrentValue() {
        return moneyRate;
    }

}
