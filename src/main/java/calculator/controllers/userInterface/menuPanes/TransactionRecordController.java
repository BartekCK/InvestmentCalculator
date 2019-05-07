package calculator.controllers.userInterface.menuPanes;

import calculator.database.tasks.TransactionTask;
import calculator.date.TransactionFx;
import calculator.user.SuperUser;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class TransactionRecordController {

    private SuperUser superUser;

    @FXML
    private AnchorPane transactionRecordAnchorPane;

    @FXML
    private TableView<TransactionFx> tableView;

    @FXML
    private TableColumn<TransactionFx, LocalDate> dateTableColumn;

    @FXML
    private TableColumn<TransactionFx, String> typeTableColumn;

    @FXML
    private TableColumn<TransactionFx, Number> buyTableColumn;

    @FXML
    private TableColumn<TransactionFx, Number> sellTableColumn;

    @FXML
    private TableColumn<TransactionFx, Number> rateTableColumn;


    public void showTable()
    {

        TransactionTask transactionTask = new TransactionTask();
        transactionTask.init(superUser);
        tableView.setItems(transactionTask.getTransactionFxObservableList());
        dateTableColumn.setCellValueFactory(cellData -> cellData.getValue().addedDateProperty());
        typeTableColumn.setCellValueFactory(cellData -> cellData.getValue().typeCurrencyProperty());
        buyTableColumn.setCellValueFactory(cellData -> cellData.getValue().buyCurrencyProperty());
        sellTableColumn.setCellValueFactory(cellData -> cellData.getValue().sellCurrencyProperty());
        rateTableColumn.setCellValueFactory(cellData -> cellData.getValue().rateValueProperty());

    }

    public void setSuperUser(SuperUser superUser) {
        this.superUser = superUser;
    }

    public AnchorPane getTransactionRecordAnchorPane() {
        return transactionRecordAnchorPane;
    }
}
