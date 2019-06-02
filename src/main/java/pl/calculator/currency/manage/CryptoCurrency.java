package pl.calculator.currency.manage;

import pl.calculator.calculate.MyMath;
import pl.calculator.currency.types.BandK;
import pl.calculator.currency.types.CaT;
import pl.calculator.currency.types.Zloty;
import pl.calculator.database.BaseModel;
import pl.calculator.exceptions.CalculatorException;
import pl.calculator.models.model.User;
import pl.calculator.utilies.converters.DateConverter;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import java.time.LocalDate;
import java.util.Date;

public abstract class CryptoCurrency extends Money implements BaseModel {

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField(columnName = "VALID_FROM", dataType = DataType.DATE_STRING, format = "yyyy-MM-dd")
    protected Date validFrom;

    @DatabaseField(columnName = "VALID_TO", dataType = DataType.DATE_STRING, format = "yyyy-MM-dd")
    protected Date validTo;


    public abstract void changeRate();

    public static double buyCurrency(User user, Money forWhatBuy,double countForWhatBuy, Money whatBuy) throws CalculatorException {


            if (whatBuy instanceof CaT) {
                if (forWhatBuy instanceof Zloty) {
                    if (user.getPolishZlotyAccount() >= countForWhatBuy) {
                        user.setPolishZlotyAccount(user.getPolishZlotyAccount() - countForWhatBuy);
                        user.setValueCaT(user.getValueCaT() + countForWhatBuy / whatBuy.moneyRate);
                        return MyMath.roundTwo(countForWhatBuy / whatBuy.moneyRate);
                    } else
                        throw new CalculatorException("Brak środków na koncie");
                }
                if (forWhatBuy instanceof BandK) {
                    if (user.getValueBandK() >= countForWhatBuy) {
//                        models.setValueBandK(models.getValueBandK() - countForWhatBuy);
//                        models.setValueCaT(models.getValueCaT() + ((countForWhatBuy * forWhatBuy.moneyRate)/whatBuy.moneyRate ));
                        throw new CalculatorException("W wersji DEMO można jedynie zmieniać waluty ze złotówek");
                    } else
                        throw new CalculatorException("Brak środków na koncie");
                }
                if(forWhatBuy instanceof CaT)
                    throw new CalculatorException("Uwaga, wybrana waluta jest niepoprawna");
            }

            if (whatBuy instanceof BandK) {
                if (forWhatBuy instanceof Zloty) {
                    if (user.getPolishZlotyAccount() >= countForWhatBuy) {
                        user.setPolishZlotyAccount(user.getPolishZlotyAccount() - countForWhatBuy);
                        user.setValueBandK(user.getValueBandK() + countForWhatBuy / whatBuy.moneyRate);
                        return MyMath.roundTwo(countForWhatBuy / whatBuy.moneyRate);
                    } else
                        throw new CalculatorException("Brak środków na koncie");
                }
                if (forWhatBuy instanceof CaT) {
                    if (user.getValueCaT() >= countForWhatBuy) {
//                        models.setValueCaT(models.getValueCaT() - countForWhatBuy);
//                        models.setValueBandK(models.getValueBandK() + ((countForWhatBuy * forWhatBuy.moneyRate)/whatBuy.moneyRate ));
                        throw new CalculatorException("W wersji DEMO można jedynie zmieniać waluty ze złotówek");
                    } else
                        throw new CalculatorException("Brak środków na koncie");
                }
                if(forWhatBuy instanceof BandK)
                    throw new CalculatorException("Uwaga, wybrana waluta jest niepoprawna");
            }

            if (whatBuy instanceof Zloty) {
                if (forWhatBuy instanceof BandK) {
                    if (user.getValueBandK() >= countForWhatBuy) {
                        user.setValueBandK(user.getValueBandK() - countForWhatBuy);
                        user.setPolishZlotyAccount(user.getPolishZlotyAccount() + forWhatBuy.moneyRate*countForWhatBuy);
                    } else
                        throw new CalculatorException("Brak środków na koncie");
                }
                if (forWhatBuy instanceof CaT) {
                    if (user.getValueCaT() >= countForWhatBuy) {
                        user.setValueCaT(user.getValueCaT() - countForWhatBuy);
                        user.setPolishZlotyAccount(user.getPolishZlotyAccount() + forWhatBuy.moneyRate*countForWhatBuy);
                    } else
                        throw new CalculatorException("Brak środków na koncie");
                }
                if(forWhatBuy instanceof Zloty)
                    throw new CalculatorException("Uwaga, wybrana waluta jest niepoprawna");
            }
            return MyMath.roundTwo((forWhatBuy.moneyRate*countForWhatBuy));
    }




    public void setValidFromAndValidTo(LocalDate actuallDate)
    {
        this.validFrom = DateConverter.convertToDate(actuallDate);
        this.validTo = DateConverter.convertToDate(actuallDate.plusDays(1));
    }

    public void setPolishMoney(double polishMoney) {
        this.polishMoney = polishMoney;
    }

    public int getId() {
        return id;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }
}
