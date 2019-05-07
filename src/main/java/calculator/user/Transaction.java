package calculator.user;

import calculator.database.BaseModel;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "TRANSACTION")
public class Transaction implements BaseModel {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "SUPER_USER_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private SuperUser superUser;

    @DatabaseField(columnName = "TRANSACTION_DATE", dataType = DataType.DATE_STRING, format = "yyyy-MM-dd")
    private Date addedDate;

    @DatabaseField(columnName = "CURRENCY", canBeNull = true)
    private String typeCurrency;

    @DatabaseField(columnName = "BUY_CURRENCY", canBeNull = true)
    private Double buyCurrency;

    @DatabaseField(columnName = "SELL_CURRENCY", canBeNull = true)
    private Double sellCurrency;

    @DatabaseField(columnName = "RATE_VALUE", canBeNull = true)
    private Double rateValue;

    public Transaction() {
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

    public String getTypeCurrency() {
        return typeCurrency;
    }

    public void setTypeCurrency(String typeCurrency) {
        this.typeCurrency = typeCurrency;
    }

    public Double getBuyCurrency() {
        return buyCurrency;
    }

    public void setBuyCurrency(Double buyCurrency) {
        this.buyCurrency = buyCurrency;
    }

    public Double getSellCurrency() {
        return sellCurrency;
    }

    public void setSellCurrency(Double sellCurrency) {
        this.sellCurrency = sellCurrency;
    }

    public Double getRateValue() {
        return rateValue;
    }

    public void setRateValue(Double rateValue) {
        this.rateValue = rateValue;
    }
}
