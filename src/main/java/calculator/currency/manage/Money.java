package calculator.currency.manage;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public abstract class Money {

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField(columnName = "POLISH_MONEY", canBeNull = false)
    protected double polishMoney;

    @DatabaseField(columnName = "VALID_FROM", dataType = DataType.DATE_STRING, format = "yyyy-MM-dd HH:mm")
    protected Date validFrom;

    @DatabaseField(columnName = "VALID_TO", dataType = DataType.DATE_STRING, format = "yyyy-MM-dd HH:mm")
    protected Date validTo;

    protected String currencyName;
    protected String currencyShort;

    @Override
    public String toString() {
        return currencyName +" ("+currencyShort+")";
    }

    public abstract double returnCurrentValue();


}