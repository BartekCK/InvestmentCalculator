package pl.calculator.controllers.remuneration;

import pl.calculator.calculate.remuneration.RemunerationBoss;
import pl.calculator.calculate.remuneration.RemunerationPerson;
import pl.calculator.calculate.remuneration.Taxes;
import pl.calculator.exceptions.CalculatorException;
import pl.calculator.exceptions.Dialogs;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class RemunerationController {

    @FXML
    private TextField grossSalary;

    @FXML
    private RadioButton checkBoxLower;

    @FXML
    private TextField accidentInsurance;

    @FXML
    private TextField netEarnings;

    @FXML
    private TextField grossEmployeeCost;



    @FXML
    void calculate() {

        double whereLives;
        if(checkBoxLower.isSelected())
            whereLives = 111.25;
        else
            whereLives = 139.06;

        try {
            if (accidentInsurance.getText().isEmpty())
                throw new CalculatorException("Uzupełnij ubezpieczenie wypadkowe");
            earnings(new RemunerationPerson(whereLives),netEarnings);
            earnings(new RemunerationBoss(Double.parseDouble(accidentInsurance.getText())),grossEmployeeCost);
        } catch (CalculatorException e) {
            Dialogs.errorDialog(e.getMessage());
        }
        catch (NumberFormatException e)
        {
         Dialogs.errorDialog("Należy podać liczbę"," Uwaga w przypadku liczby dziesiętnej operatorem dziesiętnym jest '.'(Kropka)");
        }
    }

    private void earnings(Taxes remuneration, TextField textField) throws CalculatorException {
        remuneration.setInsurancePremium(((grossAmount, percent) -> grossAmount * percent),Double.parseDouble(grossSalary.getText()));//klasa anonimowa
        textField.setText(String.valueOf(remuneration.calculate(Double.parseDouble(grossSalary.getText()))));
    }

}
