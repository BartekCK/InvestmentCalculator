package calculator.models.model;

import calculator.database.BaseModel;
import calculator.models.model.SuperUser;
import calculator.utilies.converters.DateConverter;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.time.LocalDate;
import java.util.Date;

@DatabaseTable(tableName = "TRANSACTION")
public class Transaction implements BaseModel {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "SUPER_USER_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private SuperUser superUser;

    @DatabaseField(columnName = "TRANSACTION_DATE", dataType = DataType.DATE_STRING, format = "yyyy-MM-dd")
    private Date addedDate;



    @DatabaseField(columnName = "BUY_TYPE_CURRENCY")
    private String buyTypeCurrency;

    @DatabaseField(columnName = "BUY_COUNT_CURRENCY")
    private String buyCountCurrency;

    @DatabaseField(columnName = "BUY_RATE_CURRENCY")
    private Double buyRateCurrency;



    @DatabaseField(columnName = "SELL_TYPE_CURRENCY")
    private String sellTypeCurrency;

    @DatabaseField(columnName = "SELL_COUNT_CURRENCY")
    private String sellCountCurrency;

    @DatabaseField(columnName = "SELL_RATE_CURRENCY")
    private Double sellRateCurrency;


    public Transaction() {
    }


    public Transaction(SuperUser superUser, LocalDate addedDate, String buyTypeCurrency, String buyCountCurrency, Double buyRateCurrency, String sellTypeCurrency, String sellCountCurrency, Double sellRateCurrency) {
        this.superUser = superUser;
        this.addedDate = DateConverter.convertToDate(addedDate);
        this.buyTypeCurrency = buyTypeCurrency;
        this.buyCountCurrency = buyCountCurrency;
        this.buyRateCurrency = buyRateCurrency;
        this.sellTypeCurrency = sellTypeCurrency;
        this.sellCountCurrency = sellCountCurrency;
        this.sellRateCurrency = sellRateCurrency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SuperUser getSuperUser() {
        return superUser;
    }

    public void setSuperUser(SuperUser superUser) {
        this.superUser = superUser;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getBuyTypeCurrency() {
        return buyTypeCurrency;
    }

    public void setBuyTypeCurrency(String buyTypeCurrency) {
        this.buyTypeCurrency = buyTypeCurrency;
    }

    public String getBuyCountCurrency() {
        return buyCountCurrency;
    }

    public void setBuyCountCurrency(String buyCountCurrency) {
        this.buyCountCurrency = buyCountCurrency;
    }

    public Double getBuyRateCurrency() {
        return buyRateCurrency;
    }

    public void setBuyRateCurrency(Double buyRateCurrency) {
        this.buyRateCurrency = buyRateCurrency;
    }

    public String getSellTypeCurrency() {
        return sellTypeCurrency;
    }

    public void setSellTypeCurrency(String sellTypeCurrency) {
        this.sellTypeCurrency = sellTypeCurrency;
    }

    public String getSellCountCurrency() {
        return sellCountCurrency;
    }

    public void setSellCountCurrency(String sellCountCurrency) {
        this.sellCountCurrency = sellCountCurrency;
    }

    public Double getSellRateCurrency() {
        return sellRateCurrency;
    }

    public void setSellRateCurrency(Double sellRateCurrency) {
        this.sellRateCurrency = sellRateCurrency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", superUser=" + superUser +
                ", addedDate=" + addedDate +
                ", buyTypeCurrency='" + buyTypeCurrency + '\'' +
                ", buyCountCurrency='" + buyCountCurrency + '\'' +
                ", buyRateCurrency=" + buyRateCurrency +
                ", sellTypeCurrency='" + sellTypeCurrency + '\'' +
                ", sellCountCurrency='" + sellCountCurrency + '\'' +
                ", sellRateCurrency=" + sellRateCurrency +
                '}';
    }
}
