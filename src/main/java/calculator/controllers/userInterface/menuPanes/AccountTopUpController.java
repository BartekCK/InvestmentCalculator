package calculator.controllers.userInterface.menuPanes;

import calculator.database.tasks.UserTask;
import calculator.user.SuperUser;
import calculator.user.User;
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
    void addCashZl(ActionEvent event) {
        user.setPolishZlotyAccount(user.getPolishZlotyAccount()+tSlider.getValue());
        userTask.addUserToDataBase((SuperUser) user);//rzutowanie w gore
        addButton.setDisable(true);
    }

    public AnchorPane getTopUpAccountAnchorPane() {
        return topUpAccountAnchorPane;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
