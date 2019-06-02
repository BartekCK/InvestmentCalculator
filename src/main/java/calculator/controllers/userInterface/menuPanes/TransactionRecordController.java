package calculator.controllers.userInterface.menuPanes;

import calculator.database.tasks.TransactionTask;
import calculator.models.modelFx.TransactionFx;
import calculator.models.model.SuperUser;
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
    private TableColumn<TransactionFx, String> buyTypeTableColumn;

    @FXML
    private TableColumn<TransactionFx, String> buyCountTableColumn;

    @FXML
    private TableColumn<TransactionFx, Number> buyRateTableColumn;

    @FXML
    private TableColumn<TransactionFx, String> sellTypeTableColumn;

    @FXML
    private TableColumn<TransactionFx, String> sellCountTableColumn;

    @FXML
    private TableColumn<TransactionFx, Number> sellRateTableColumn;


    public void showTable()
    {
        TransactionTask transactionTask = new TransactionTask();

        tableView.setItems(transactionTask.returnFxList(superUser));
        dateTableColumn.setCellValueFactory(cell->cell.getValue().addedDateProperty());

        buyTypeTableColumn.setCellValueFactory(cell->cell.getValue().buyTypeCurrencyProperty());
        buyCountTableColumn.setCellValueFactory(cell->cell.getValue().buyCountCurrencyProperty());
        buyRateTableColumn.setCellValueFactory(cell->cell.getValue().buyRateCurrencyProperty());

        sellTypeTableColumn.setCellValueFactory(cell->cell.getValue().sellTypeCurrencyProperty());
        sellCountTableColumn.setCellValueFactory(cell->cell.getValue().sellCountCurrencyProperty());
        sellRateTableColumn.setCellValueFactory(cell->cell.getValue().sellRateCurrencyProperty());
    }

    public void setSuperUser(SuperUser superUser) {
        this.superUser = superUser;
    }

    public AnchorPane getTransactionRecordAnchorPane() {
        return transactionRecordAnchorPane;
    }
}
