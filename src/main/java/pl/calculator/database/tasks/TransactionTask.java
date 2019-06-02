package pl.calculator.database.tasks;

import pl.calculator.models.modelFx.TransactionFx;
import pl.calculator.models.model.SuperUser;
import pl.calculator.models.model.Transaction;
import pl.calculator.utilies.converters.ListConverter;
import pl.calculator.utilies.converters.TransactionConverter;
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
