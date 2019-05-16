package calculator.currency.manage;

import calculator.database.BaseModel;
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

    @DatabaseField(columnName = "MONEY_RATE", canBeNull = false)
    protected double moneyRate;


    public abstract void changeRate();

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

    public double getMoneyRate() {
        return moneyRate;
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
