package pl.calculator.utilies.converters;

import pl.calculator.currency.manage.CryptoCurrency;
import pl.calculator.models.modelFx.CryptoCurrencyFx;

public class CryptoCurrencyConverter {

    public static CryptoCurrencyFx convertToCryptoCurrencyFx(CryptoCurrency cryptoCurrency)
    {
        CryptoCurrencyFx cryptoCurrencyFx = new CryptoCurrencyFx();
        cryptoCurrencyFx.setCurrencyName(cryptoCurrency.getCurrencyName());
        cryptoCurrencyFx.setCurrencyShort(cryptoCurrency.getCurrencyShort());
        cryptoCurrencyFx.setId(cryptoCurrency.getId());
        cryptoCurrencyFx.setPolishMoney(cryptoCurrency.getPolishMoney());
        cryptoCurrencyFx.setValidFrom(DateConverter.convertToLocalDate(cryptoCurrency.getValidFrom()));
        cryptoCurrencyFx.setValidTo(DateConverter.convertToLocalDate(cryptoCurrency.getValidTo()));
        cryptoCurrencyFx.setMoneyRate(cryptoCurrency.getMoneyRate());

        return cryptoCurrencyFx;
    }
}
