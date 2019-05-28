package calculator.controllers.userInterface.menuPanes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StatisticController {

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> numberTableColumn;

    @FXML
    private TableColumn<?, ?> emailTableColumn;

    @FXML
    private TableColumn<?, ?> countTableColumn;

    @FXML
    private TableColumn<?, ?> currencyTableColumn;

    @FXML
    private ComboBox<?> chooseComboBox;

    @FXML
    void checkAction(ActionEvent event) {

    }

}
