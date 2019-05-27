package calculator.controllers.loansAndDeposits;

import calculator.calculate.loansAndDeposit.BankCalculate;
import calculator.calculate.loansAndDeposit.DecreasingInstallmentFx;
import calculator.calculate.loansAndDeposit.LoansCalculate;
import calculator.exceptions.CalculatorException;
import calculator.exceptions.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.text.NumberFormat;

public class LoansController {
    
    @FXML
    private TextField loansValueTextField;

    @FXML
    private TextField installmentCountTextField;

    @FXML
    private Slider percentSlider;

    @FXML
    private TextField percentTextField;

    @FXML
    private TableView<DecreasingInstallmentFx> tableView;

    @FXML
    private TableColumn<DecreasingInstallmentFx, Number> installmentNumberTableColumn;

    @FXML
    private TableColumn<DecreasingInstallmentFx, Number> valueTableColumn;

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
        LoansCalculate loansCalculate = new BankCalculate();


        try {
            if(percentTextField.getText().isEmpty() || Double.parseDouble(percentTextField.getText().replace(",","."))<=0)
                throw new CalculatorException("Zły dobór procentow :)");
            loansCalculate.parametrQ(percentSlider.getValue());
            loansCalculate.amountInstallment(Double.parseDouble(loansValueTextField.getText()),Integer.parseInt(installmentCountTextField.getText()));
        }catch (NumberFormatException e)
        {
            Dialogs.errorDialog("Dane zostały wprowadzone nieprawidłowo");
        } catch (CalculatorException e) {
            Dialogs.errorDialog(e.getMessage());
        }

        resultInstallment.setText(String.valueOf(loansCalculate.getResultInstallment()));
        resultValue1.setText(String.valueOf(((BankCalculate) loansCalculate).getResultValue1()));
        resultValue2.setText(String.valueOf(((BankCalculate) loansCalculate).getResultValue2()));


        tableView.setItems(loansCalculate.getListFx());
        installmentNumberTableColumn.setCellValueFactory(cell-> cell.getValue().numberProperty());
        valueTableColumn.setCellValueFactory(cell-> cell.getValue().valueProperty());
    }

}

