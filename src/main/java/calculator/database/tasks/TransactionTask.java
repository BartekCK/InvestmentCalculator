package calculator.database.tasks;

import calculator.date.TransactionFx;
import calculator.user.SuperUser;
import calculator.date.Transaction;
import calculator.utilies.converters.ListConverter;
import calculator.utilies.converters.TransactionConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class TransactionTask {



    public ObservableList<TransactionFx> returnFxList(SuperUser superUser)
    {
        ListConverter<Transaction,TransactionConverter,TransactionFx> listConverter = (list, converter) -> {
            ObservableList<TransactionFx> temp = FXCollections.observableArrayList();
            list.forEach(e->{ temp.add(converter.convertToTransactionFx(e));});
            return temp;
        };
        return listConverter.returnFxObject(superUser.getTransactions(), new TransactionConverter());
    }


}
