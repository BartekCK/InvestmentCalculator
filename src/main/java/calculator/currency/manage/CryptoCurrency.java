package calculator.currency.manage;

import calculator.calculate.MyMath;
import calculator.currency.types.BandK;
import calculator.currency.types.CaT;
import calculator.currency.types.Zloty;
import calculator.database.BaseModel;
import calculator.exceptions.CalculatorException;
import calculator.user.User;
import calculator.utilies.converters.ConvertToDate;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import java.time.LocalDate;
import java.util.Date;

public abstract class CryptoCurrency extends Money implements BaseModel {

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField(columnName = "POLISH_MONEY", canBeNull = false)
    protected double polishMoney;

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
                        user.setValueBandK(user.getValueBandK() - countForWhatBuy);
                        user.setValueCaT(user.getValueCaT() + ((countForWhatBuy / forWhatBuy.moneyRate) * whatBuy.moneyRate));
                    } else
                        throw new CalculatorException("Brak środków na koncie");
                }
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
                        user.setValueCaT(user.getValueCaT() - countForWhatBuy);
                        user.setValueBandK(user.getValueBandK() + ((countForWhatBuy / forWhatBuy.moneyRate) * whatBuy.moneyRate));
                    } else
                        throw new CalculatorException("Brak środków na koncie");
                }
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
            }
            return MyMath.roundTwo((forWhatBuy.moneyRate*countForWhatBuy));
    }


    public void setValidFromAndValidTo(LocalDate actuallDate)
    {
        this.validFrom = ConvertToDate.convertToDate(actuallDate);
        this.validTo = ConvertToDate.convertToDate(actuallDate.plusDays(1));
    }

    public double getPolishMoney() {
        return polishMoney;
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
