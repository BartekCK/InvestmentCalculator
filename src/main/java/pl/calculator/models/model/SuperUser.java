package pl.calculator.models.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



@DatabaseTable(tableName = "SUPER_USER")
public class SuperUser extends User {

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Transaction> transactions;

    public SuperUser(String email, String password, String nick) {
        super(email, password, nick);
    }

    public SuperUser() {
    }

    public ObservableList<Transaction> getTransactions() {
        return FXCollections.observableArrayList(transactions);
    }
    public void addTransaction(Transaction transaction)
    {
        transactions.add(transaction);
    }


}
