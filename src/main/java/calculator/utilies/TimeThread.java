package calculator.utilies;

import calculator.currency.manage.CryptoCurrency;
import calculator.currency.manage.ManageCurrency;
import calculator.currency.types.BandK;
import calculator.currency.types.CaT;
import calculator.database.tasks.CurrencyTask;
import java.io.*;
import java.time.LocalDate;

public class TimeThread implements Serializable {
    private LocalDate lastSaveDay;


    public TimeThread() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("dateConfig.bin"))) {
            lastSaveDay = (LocalDate) inputStream.readObject();
            checkToday();
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

    public void saveDay()
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
        ManageCurrency [] manageCurrencies = new ManageCurrency[]{new CaT(),new BandK()};
        for (ManageCurrency currency : manageCurrencies) {

            ((CryptoCurrency)currency).setPolishMoney(currencyTask.getPolishMoneyFromLast(currency,localDate.minusDays(1)));
            currency.changeRate();
            ((CryptoCurrency)currency).setValidFromAndValidTo(localDate);
            currencyTask.addCurrencyToDataBase(currency);

        }

    }
}
