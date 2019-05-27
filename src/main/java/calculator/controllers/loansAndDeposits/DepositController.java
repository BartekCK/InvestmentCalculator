package calculator.controllers.loansAndDeposits;

import calculator.calculate.loansAndDeposit.BankCalculate;
import calculator.calculate.loansAndDeposit.DepositCalculate;
import calculator.exceptions.CalculatorException;
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
    private TextField percentTextField;

    @FXML
    private TextField showProfitTextField;

    @FXML
    private TextField countDay;

    @FXML
    public void initialize()
    {
        percentTextField.textProperty().bindBidirectional(percentSlider.valueProperty(), NumberFormat.getNumberInstance());
        button.disableProperty().bind(valueTextField.textProperty().isEmpty().or(fromDate.valueProperty().isNull().or(toDate.valueProperty().isNull())));

    }

    @FXML
    void calculateProfit() {
        DepositCalculate depositCalculate = new BankCalculate();
        try {
            if(percentTextField.getText().isEmpty() || Double.parseDouble(percentTextField.getText().replace(",","."))<=0)
                throw new CalculatorException("Zły dobór procentow :)");
            countDay.setText(String.valueOf(calculateDayDiffrence()));
            showProfitTextField.setText(String.valueOf(depositCalculate.depositProfit(Double.parseDouble(valueTextField.getText()),percentSlider.getValue(),calculateDayDiffrence())));
            showProfitTextField.setText(showProfitTextField.getText() + " zł brutto");
        }
        catch (CalculatorException e)
        {
            Dialogs.errorDialog(e.getMessage());
        }
        catch (NumberFormatException e)
        {
            Dialogs.errorDialog("Dane zostały wprowadzone nieprawidłowo");
        }

    }
    
    private int calculateDayDiffrence()
    {
        return (int)DAYS.between(fromDate.getValue(),toDate.getValue());

    }

}
