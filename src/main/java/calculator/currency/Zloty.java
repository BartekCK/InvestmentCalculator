package calculator.currency;

import calculator.currency.manage.Money;

public class Zloty extends Money {

    public Zloty() {
        currencyName = "Złoty";
        currencyShort = "PLN";
    }

    @Override
    public double returnCurrentValue() {
        return 1;
    }
}
