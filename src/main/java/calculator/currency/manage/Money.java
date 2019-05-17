package calculator.currency.manage;

import com.j256.ormlite.field.DatabaseField;

public abstract class Money {

    protected String currencyName;
    protected String currencyShort;

    @DatabaseField(columnName = "MONEY_RATE", canBeNull = false)
    protected double moneyRate;

    @Override
    public String toString() {
        return currencyName +" ("+currencyShort+")";
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencyShort() {
        return currencyShort;
    }

    public double getMoneyRate() {
        return moneyRate;
    }
}
