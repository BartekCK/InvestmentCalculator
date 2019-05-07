package calculator.database.tasks;

import calculator.database.dao.TransactionDao;
import calculator.exceptions.CalculatorException;
import calculator.date.TransactionFx;
import calculator.user.SuperUser;
import calculator.date.Transaction;
import calculator.utilies.converters.TransactionConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionTask {

    private ObservableList<Transaction> transactionObservableList = FXCollections.observableArrayList();
    private ObservableList<TransactionFx> transactionFxObservableList = FXCollections.observableArrayList();
    private List<Transaction> transactionList = new ArrayList<>();

    private void pullTransactionFromDataBase(SuperUser superUser)
    {
        TransactionDao transactionDao = new TransactionDao();
        try {
            transactionList = transactionDao.pushTransactionByUserId(superUser);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }
    public void init(SuperUser superUser)
    {
        pullTransactionFromDataBase(superUser);
        transactionList.forEach(transaction -> transactionFxObservableList.add(TransactionConverter.convertToTransactionFx(transaction)));
    }

    public ObservableList<TransactionFx> getTransactionFxObservableList() {
        return transactionFxObservableList;
    }
}
