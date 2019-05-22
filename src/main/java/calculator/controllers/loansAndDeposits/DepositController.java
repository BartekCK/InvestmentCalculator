package calculator.controllers.loansAndDeposits;

import calculator.calculate.BankCalculate;
import calculator.calculate.DepositCalculate;
import calculator.exceptions.Dialogs;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;


import java.text.NumberFormat;

import static java.time.temporal.ChronoUnit.DAYS;

public class DepositController {

    @FXML
    private Button button;

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
    private TextField showProfitTextField;

    @FXML
    private TextField countDay;

    @FXML
    public void initialize()
    {
        percentTableView.textProperty().bindBidirectional(percentSlider.valueProperty(), NumberFormat.getNumberInstance());
        button.disableProperty().bind(valueTextField.textProperty().isEmpty().or(fromDate.valueProperty().isNull().or(toDate.valueProperty().isNull())));

    }

    @FXML
    void calculateProfit() {
        DepositCalculate depositCalculate = new BankCalculate();
        try {
            countDay.setText(String.valueOf(calculateDayDiffrence()));
            showProfitTextField.setText(String.valueOf(depositCalculate.depositProfit(Double.parseDouble(valueTextField.getText()),percentSlider.getValue(),calculateDayDiffrence())));
            showProfitTextField.setText(showProfitTextField.getText() + " zł brutto");
        }catch (NumberFormatException e)
        {
            Dialogs.errorDialog("Dane zostały wprowadzone nieprawidłowo");
        }

    }
    
    private int calculateDayDiffrence()
    {
        return (int)DAYS.between(fromDate.getValue(),toDate.getValue());

    }

}
