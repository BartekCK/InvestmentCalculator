package calculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.text.NumberFormat;

import static java.time.temporal.ChronoUnit.DAYS;

public class DepositController {

    @FXML
    private Button button;

    @FXML
    private AnchorPane depositAnchorPane;

    @FXML
    private TextField valueTextField;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private Slider percentSlider;

    @FXML
    private TextField percentTableView;

    @FXML
    private TextField showProfitTableView;

    @FXML
    public void initialize()
    {
        percentTableView.textProperty().bindBidirectional(percentSlider.valueProperty(), NumberFormat.getNumberInstance());
        button.disableProperty().bind(valueTextField.textProperty().isEmpty().or(fromDate.valueProperty().isNull().or(toDate.valueProperty().isNull())));
    }

    @FXML
    void calculateProfit(ActionEvent event) {

    }
    
    private long calculateDayDiffrence()
    {
        return DAYS.between(fromDate.getValue(),toDate.getValue());

    }

}
