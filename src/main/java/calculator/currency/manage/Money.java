package calculator.currency.manage;

public abstract class Money {

    protected String currencyName;
    protected String currencyShort;

    @Override
    public String toString() {
        return currencyName +" ("+currencyShort+")";
    }
}
