package calculator.user;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "SUPER_USER")
public class SuperUser extends User {

    @ForeignCollectionField(eager = true)
    private ForeignCollection<TransactionRecord> transactionRecords;

    public SuperUser(String email, String password, String nick) {
        super(email, password, nick);
    }

    public SuperUser() {
    }
}
