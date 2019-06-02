package pl.calculator.currency.types;

import pl.calculator.calculate.MyMath;
import pl.calculator.currency.manage.CryptoCurrency;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Random;


@DatabaseTable(tableName = "B_AND_K_MONEY")
public class BandK extends CryptoCurrency
{


    public BandK() {
        currencyName = "BandK";
        currencyShort = "BK";
    }

    @Override
    public void changeRate() {
        Random random = new Random();
        moneyRate = MyMath.roundTwo(random.nextDouble() *5 + (this.polishMoney/100000));
        System.out.println(moneyRate);
    }



}
