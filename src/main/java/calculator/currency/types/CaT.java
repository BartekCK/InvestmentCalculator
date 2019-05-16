package calculator.currency.types;

import calculator.calculate.MyMath;
import calculator.currency.manage.CryptoCurrency;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Random;


@DatabaseTable(tableName = "CAT_MONEY")
public class CaT extends CryptoCurrency {


    public CaT() {
        currencyName = "CaT";
        currencyShort = "CT";
    }

    @Override
    public void changeRate() {
        Random random = new Random();
        moneyRate = MyMath.roundTwo(random.nextDouble() * 2 - (1-(1*this.polishMoney/1000000)));
        System.out.println(moneyRate);
    }



}
