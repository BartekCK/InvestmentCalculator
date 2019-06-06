package pl.calculator.currency.types;

import pl.calculator.calculate.MyMath;
import pl.calculator.currency.manage.CryptoCurrency;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Random;


@DatabaseTable(tableName = "CAT_MONEY")
public class CaT extends CryptoCurrency {


    public CaT() {
        currencyName = "CaT";
        currencyShort = "CT";
    }

    @Override
    public final void changeRate() {
        Random random = new Random();
        moneyRate = MyMath.roundTwo(random.nextDouble() * 2 + (this.polishMoney/1000000));
        System.out.println(moneyRate);
    }



}
