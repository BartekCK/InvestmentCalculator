package calculator.utilies;

import calculator.currency.manage.CryptoCurrency;
import calculator.currency.types.BandK;
import calculator.currency.types.CaT;
import calculator.database.tasks.CurrencyTask;
import java.io.*;
import java.time.LocalDate;

public class TimeThread implements Serializable {
    private static LocalDate lastSaveDay;


    public TimeThread() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("dateConfig.bin"))) {
            lastSaveDay = (LocalDate) inputStream.readObject();
            checkToday();
            saveDay();
        } catch (ClassNotFoundException| IOException e) {
            lastSaveDay = LocalDate.now();
            setCurrency(lastSaveDay);
            saveDay();
        }


    }

    private void checkToday()
    {
        LocalDate localDate = LocalDate.now();
        while (!lastSaveDay.equals(localDate))
        {
            lastSaveDay = lastSaveDay.plusDays(1);
            setCurrency(lastSaveDay);
        }
    }

    private void saveDay()
    {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("dateConfig.bin"));
            outputStream.writeObject(lastSaveDay);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setCurrency(LocalDate localDate)
    {
        CurrencyTask currencyTask = new CurrencyTask();
        CryptoCurrency[] cryptoCurrencies = new CryptoCurrency[]{new CaT(),new BandK()};
        for (CryptoCurrency currency : cryptoCurrencies) {

            currency.setPolishMoney(currencyTask.getPolishMoneyFromLast(currency,localDate.minusDays(1)));
            currency.changeRate();
            currency.setValidFromAndValidTo(localDate);
            currencyTask.addCurrencyToDataBase(currency);

        }

    }

    public static LocalDate getLastSaveDay() {
        return lastSaveDay;
    }
}
