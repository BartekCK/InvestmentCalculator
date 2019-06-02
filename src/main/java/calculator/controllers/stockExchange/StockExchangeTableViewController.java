package calculator.controllers.stockExchange;

import calculator.models.modelFx.CryptoCurrencyFx;
import calculator.currency.types.BandK;
import calculator.currency.types.CaT;
import calculator.database.tasks.CurrencyTask;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class StockExchangeTableViewController {

    @FXML
    private TableView<CryptoCurrencyFx> bandKTableView;

    @FXML
    private TableColumn<CryptoCurrencyFx, Number> idBandkTableColumn;

    @FXML
    private TableColumn<CryptoCurrencyFx, String> nameBandkTableColumn;

    @FXML
    private TableColumn<CryptoCurrencyFx, LocalDate> timeFromBandkTableColumn;

    @FXML
    private TableColumn<CryptoCurrencyFx, LocalDate> timeToBandkTableColumn;

    @FXML
    private TableColumn<CryptoCurrencyFx, Number> valueBandkTableColumn;


    @FXML
    private TableView<CryptoCurrencyFx> catTableView;

    @FXML
    private TableColumn<CryptoCurrencyFx, Number> idCatTableColumn;

    @FXML
    private TableColumn<CryptoCurrencyFx, String> nameCatTableColumn;

    @FXML
    private TableColumn<CryptoCurrencyFx, LocalDate> timeFromCatTableColumn;

    @FXML
    private TableColumn<CryptoCurrencyFx, LocalDate> timeToCatTableColumn;

    @FXML
    private TableColumn<CryptoCurrencyFx, Number> valueCatTableColumn;


    @FXML
    public void initialize()
    {
        CurrencyTask currencyTask = new CurrencyTask();
        ObservableList<CryptoCurrencyFx> listFxBandK = currencyTask.pushAllCurrencies(new BandK());
        ObservableList<CryptoCurrencyFx> listFxCaT = currencyTask.pushAllCurrencies(new CaT());

        show(listFxBandK, catTableView, idBandkTableColumn, nameBandkTableColumn, timeFromBandkTableColumn, timeToBandkTableColumn, valueBandkTableColumn);
        show(listFxCaT, bandKTableView, idCatTableColumn, nameCatTableColumn, timeFromCatTableColumn, timeToCatTableColumn, valueCatTableColumn);

    }

    private void show(ObservableList<CryptoCurrencyFx> listFxCaT, TableView<CryptoCurrencyFx> bandKTableView, TableColumn<CryptoCurrencyFx, Number> idCatTableColumn,
                       TableColumn<CryptoCurrencyFx, String> nameCatTableColumn, TableColumn<CryptoCurrencyFx, LocalDate> timeFromCatTableColumn,
                       TableColumn<CryptoCurrencyFx, LocalDate> timeToCatTableColumn, TableColumn<CryptoCurrencyFx, Number> valueCatTableColumn) {
        bandKTableView.setItems(listFxCaT);
        idCatTableColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nameCatTableColumn.setCellValueFactory(cellData -> cellData.getValue().currencyNameProperty());
        timeFromCatTableColumn.setCellValueFactory(cellData -> cellData.getValue().validFromProperty());
        timeToCatTableColumn.setCellValueFactory(cellData -> cellData.getValue().validToProperty());
        valueCatTableColumn.setCellValueFactory(cellData -> cellData.getValue().moneyRateProperty());
    }


}
