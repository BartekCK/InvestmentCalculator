package pl.calculator.controllers.userInterface.menuPanes;

import pl.calculator.database.tasks.UserTask;
import pl.calculator.exceptions.CalculatorException;
import pl.calculator.exceptions.Dialogs;
import pl.calculator.logs.Log;
import pl.calculator.logs.SaveLogs;
import pl.calculator.models.model.SuperUser;
import pl.calculator.models.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.text.NumberFormat;

public class AccountTopUpController {


    private User user;
    private UserTask userTask;

    @FXML
    private Button addButton;

    @FXML
    private AnchorPane topUpAccountAnchorPane;

    @FXML
    private Slider tSlider;

    @FXML
    private TextField valueTextField;

    @FXML
    public void initialize()
    {
        userTask = new UserTask();
        valueTextField.textProperty().bindBidirectional(tSlider.valueProperty(), NumberFormat.getNumberInstance());
    }

    @FXML
    void addCashZl() {
        try
        {
            if( user == null)
                throw new CalculatorException("Użytkownik został wyrejestrowany");
            user.setPolishZlotyAccount(user.getPolishZlotyAccount()+tSlider.getValue());
            userTask.addUserToDataBase((SuperUser) user);//rzutowanie w dół
            addButton.setDisable(true);
            SaveLogs.saveToFile(new Log("Doładowanie konta"));
        } catch (CalculatorException e) {
            Dialogs.errorDialog(e.getMessage());
        }

    }

    public AnchorPane getTopUpAccountAnchorPane() {
        return topUpAccountAnchorPane;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
