package calculator.user;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "TRANSACTION")
public class Transaction {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "SUPER_USER_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private SuperUser superUser;

    @DatabaseField(columnName = "TRANSACTION_DATE",dataType = DataType.DATE_STRING,format = "yyyy-MM-dd")
    private Date addedDate;

    public Transaction() {
    }
}
