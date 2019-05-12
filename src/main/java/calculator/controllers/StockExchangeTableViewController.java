package calculator.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StockExchangeTableViewController {

    @FXML
    private TableView<?> bandKTableView;

    @FXML
    private TableColumn<?, ?> idBandkTableColumn;

    @FXML
    private TableColumn<?, ?> nameBandkTableColumn;

    @FXML
    private TableColumn<?, ?> timeFromBandkTableColumn;

    @FXML
    private TableColumn<?, ?> timeToBandkTableColumn;

    @FXML
    private TableColumn<?, ?> valueBandkTableColumn;

    @FXML
    private TableView<?> catTableView;

    @FXML
    private TableColumn<?, ?> idCatTableColumn;

    @FXML
    private TableColumn<?, ?> nameCatTableColumn;

    @FXML
    private TableColumn<?, ?> timeFromCatTableColumn;

    @FXML
    private TableColumn<?, ?> timeToCatTableColumn;

    @FXML
    private TableColumn<?, ?> valueCatTableColumn;

}
