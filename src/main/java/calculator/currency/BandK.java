package calculator.currency;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


@DatabaseTable(tableName = "B_AND_K_MONEY")
public class BandK implements ManageCurrency {

    private final String name = "BandK";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "MONEY_RATE", canBeNull = false)
    static private double moneyRate;

    @DatabaseField(columnName = "VALID_FROM", dataType = DataType.DATE_TIME, format = "yyyy-MM-dd-HH:mm:ss")
    private Date validFrom;

    @DatabaseField(columnName = "VALID_TO", dataType = DataType.DATE_TIME, format = "yyyy-MM-dd-HH:mm:ss")
    private Date validTo;

    public BandK() {
    }

    @Override
    public void changeRate() {

    }

    @Override
    public double returnCurrentValue() {
        return moneyRate;
    }

    @Override
    public String returnName() {
        return name;
    }
}
