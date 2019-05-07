package calculator.controllers.loansAndDeposits;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.text.NumberFormat;

public class LoansController {

    @FXML
    private AnchorPane loansAnchorPane;

    @FXML
    private TextField loansValueTextField;

    @FXML
    private TextField installmentCountTextField;

    @FXML
    private Slider percentSlider;

    @FXML
    private TextField percentTextField;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> installmentNumberTableColumn;

    @FXML
    private TableColumn<?, ?> valueTableColumn;

    @FXML
    private TextField resultInstallment;

    @FXML
    private TextField resultValue1;

    @FXML
    private TextField resultValue2;

    @FXML
    private Button button;

    @FXML
    public void initialize()
    {
        percentTextField.textProperty().bindBidirectional(percentSlider.valueProperty(), NumberFormat.getNumberInstance());
        button.disableProperty().bind(loansValueTextField.textProperty().isEmpty().or(installmentCountTextField.textProperty().isEmpty()));
    }

    @FXML
    void calculateLoans(ActionEvent event) {

    }

}

