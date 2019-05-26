package calculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RemunerationController {

    @FXML
    private TextField grossSalary;

    @FXML
    private RadioButton checkBoxLower;

    @FXML
    private ToggleGroup group;

    @FXML
    private RadioButton checkBoxBigger;

    @FXML
    private TextField accidentInsurance;

    @FXML
    private TextField netEarnings;

    @FXML
    private TextField grossEmployeeCost;

    @FXML
    private Button button;

    @FXML
    void calculate(ActionEvent event) {

    }

}
