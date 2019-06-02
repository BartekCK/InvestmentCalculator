package pl.calculator.currency.manage;

import pl.calculator.calculate.MyMath;
import pl.calculator.currency.types.Zloty;
import com.j256.ormlite.field.DatabaseField;

public abstract class Money implements Comparable<CryptoCurrency>{

    protected String currencyName;
    protected String currencyShort;

    @DatabaseField(columnName = "MONEY_RATE", canBeNull = false)
    protected double moneyRate;

    @DatabaseField(columnName = "POLISH_MONEY", canBeNull = false)
    protected double polishMoney;

    @Override
    public String toString() {
        return currencyName +" ("+currencyShort+")";
    }

    public void buyCurrencyAddOrMinusPolishZloty(Money money,double countUnit)
    {
        if(this instanceof Zloty)
            money.polishMoney = MyMath.roundTwo(money.polishMoney -(countUnit*money.moneyRate));
        else
            this.polishMoney= MyMath.roundTwo(this.polishMoney+(countUnit/money.getMoneyRate()));
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

    @Override
    public int compareTo(CryptoCurrency money) {

        return Double.compare(moneyRate,money.moneyRate);

    }

    public double getPolishMoney() {
        return polishMoney;
    }
}
